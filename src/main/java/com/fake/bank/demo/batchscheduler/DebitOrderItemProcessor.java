package com.fake.bank.demo.batchscheduler;

import org.springframework.batch.item.ItemProcessor;

public class DebitOrderItemProcessor implements ItemProcessor<DebitOrderInfo, DebitOrderInfo>{

	@Override
	public DebitOrderInfo process(DebitOrderInfo item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
