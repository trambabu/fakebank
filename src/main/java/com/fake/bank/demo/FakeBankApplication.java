package com.fake.bank.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fake.bank.demo.config.SecurityConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//(exclude = { SecurityConfiguration.class }) 
@EnableBatchProcessing
@OpenAPIDefinition(info = @Info(title = "Fake Banking Core Banking API", version = "1.0", description = "Fake Banking Core Banking Management"))
public class FakeBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeBankApplication.class, args);
	}

}
