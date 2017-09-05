package com.harki.pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.harki.pattern.model.NetBankingType;

@Service
public class BankingFactory {

	@Qualifier("DiscountOnlineBanking")
	@Autowired
	OnlineBanking discountOnlineBanking;
	
	@Qualifier("BonusOnlineBanking")
	@Autowired
	OnlineBanking bonusOnlineBanking;
	
	public OnlineBanking getBankingInstance(NetBankingType type){
		if(type.equals(NetBankingType.BONUS))
			return bonusOnlineBanking;
		else if(type.equals(NetBankingType.DISCOUNT))
			return discountOnlineBanking;
		
		throw new IllegalArgumentException(type.name());
	}
}
