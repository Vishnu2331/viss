package com.hackathon.bankapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.bankapplication.model.Bank;
import com.hackathon.bankapplication.repository.BankDao;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
	BankDao bankDao;
	
	private static final Logger log = LoggerFactory.getLogger(BankServiceImpl.class);

	@Override
	public String getBankName(String favouriteAccountIbanNumber) {
		log.info("getting bank name based on iban number in service class");
		String bankName = null;
		String IBAN_Code=favouriteAccountIbanNumber.substring(4,8);

		Bank bank = bankDao.findByIbanCode(IBAN_Code);
		
		bankName=bank.getBankName();
		return bankName;
	}

	@Override
	public Bank saveBankDetails(Bank bank) {
		log.info("saving bank details --service class");

		return bankDao.save(bank);
	}
	 



}
