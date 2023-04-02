package com.fake.bank.demo.batchscheduler;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.WritableResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration<I, O> {

	@Autowired(required=true)
	public JobBuilder jobBuilder;

	@Autowired(required=true)
	public StepBuilder stepBuilder;

	@Autowired
	public DataSource dataSource;

	@Value("${spring.datasource.driverClassName}")
	private String dbDrivername;

	@Value("${spring.datasource.ur}")
	private String dburl;

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(dbDrivername);
		dataSource.setUrl(dburl);
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	@Bean
	public JdbcCursorItemReader<DebitOrderInfo> reader() {
		JdbcCursorItemReader<DebitOrderInfo> reader = new JdbcCursorItemReader<DebitOrderInfo>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id, accno, amount FROM accountTransaction");
		reader.setRowMapper(new DebitOrderInfoRowMapper());

		return reader;
	}

	public class DebitOrderInfoRowMapper implements RowMapper<DebitOrderInfo> {

		@Override
		public DebitOrderInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			DebitOrderInfo debitOrderInfo = new DebitOrderInfo();
			debitOrderInfo.setId(rs.getInt("id"));
			debitOrderInfo.setAccno(rs.getLong("accno"));
			debitOrderInfo.setAmount(rs.getBigDecimal("amount"));

			return debitOrderInfo;
		}

	}

	@Bean
	public DebitOrderItemProcessor processor() {
		return new DebitOrderItemProcessor() {

		};
	}

	@Bean
	public FlatFileItemWriter<DebitOrderInfo> writer() {
		FlatFileItemWriter<DebitOrderInfo> writer = new FlatFileItemWriter<DebitOrderInfo>();
		writer.setResource((WritableResource) new ClassPathResource("DebitOrderInfo.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<DebitOrderInfo>() {
			{
				setDelimiter(",");
				setFieldExtractor(new BeanWrapperFieldExtractor<DebitOrderInfo>() {
					{
						setNames(new String[] { "id", "accno", "amount" });
					}
				});
			}
		});

		return writer;
	}

	
//	@Bean
//	public Step step1() {
////		return stepBuilder.get("step1").<DebitOrderInfo, DebitOrderInfo>chunk(10).reader(reader())
////				.processor(processor()).writer(writer()).build();
//		 return new StepBuilder("step1", (JobRepository) jobBuilder)
//	                .tasklet(myTasklet, transactionManager) // or .chunk(chunkSize, transactionManager)
//	                .build();
//	}
	
	/**
	 * Note the TransactionManager is typically autowired in and not needed to be explicitly
	 * configured
	 */
	@Bean
	public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("step", jobRepository)
					.<DebitOrderInfo, DebitOrderInfo>chunk(10, transactionManager)
					.reader(reader())
					.writer(writer())
					.build();
	}

//	@Bean
//	public Job exportUserJob() {
//		return jobBuilder.get("exportUserJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
//	}

	@Bean
    public Job exportUserJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("exportUserJob", jobRepository)
                .start(step)
                .build();
    }
}
