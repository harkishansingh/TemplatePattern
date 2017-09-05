package com.harki.pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.harki.pattern.model.Customer;
import com.harki.pattern.model.NetBankingType;
import com.harki.pattern.service.BankingFactory;
import com.harki.pattern.service.BonusOnlineBanking;
import com.harki.pattern.service.OnlineBanking;
import com.harki.pattern.service.OnlineBankingJava8;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class BankingFactoryTest {
	@Autowired
	private BankingFactory factory;

	@Autowired
	OnlineBankingJava8 banking;

	@Test
	public void getBankingInstanceTest() {
		OnlineBanking banking = factory.getBankingInstance(NetBankingType.BONUS);
		banking.processCustomer("Harkishan");
		Assert.assertTrue(banking instanceof BonusOnlineBanking);
	}

	/**
	 * Using Java 8
	 */
	@Test
	public void processCustomerTest(){
		banking.processCustomer("Harki", (Customer c) -> System.out.println("Customer Name: " + c.getName()));
		
	}
}
