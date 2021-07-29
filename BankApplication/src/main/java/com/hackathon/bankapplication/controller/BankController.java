package com.hackathon.bankapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bankapplication.model.Bank;
import com.hackathon.bankapplication.service.BankService;
import com.hackathon.bankapplication.vo.AccountIbanNoVo;

@RestController
@RequestMapping("bank")
public class BankController {
    @Autowired
	BankService bankService;
   
	private static final Logger log = LoggerFactory.getLogger(BankController.class);

	
	@PostMapping("/getbankname") 
	public ResponseEntity<String> getBankName(@RequestBody AccountIbanNoVo accountIbanNoVo) {
		log.info("getting bank name based on bank iban code");
		try {
			String bankName=bankService.getBankName(accountIbanNoVo.getFavouriteAccountIbanNumber());
			return new ResponseEntity<>(bankName, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	

	@PostMapping 
	public ResponseEntity<Bank> saveBankDetails(@RequestBody Bank bank) {
		log.info("saving bank details ");
		try {
		Bank bank1=	bankService.saveBankDetails(bank);
			return new ResponseEntity<>(bank1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	
}
