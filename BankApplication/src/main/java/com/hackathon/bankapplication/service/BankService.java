package com.hackathon.bankapplication.service;

import com.hackathon.bankapplication.model.Bank;

public interface BankService {

	public String getBankName(String favouriteAccountIbanNumber);

	public Bank saveBankDetails(Bank bank);

}
