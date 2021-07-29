package com.hackathon.bankapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hackathon.bankapplication.exception.RecordNotFoundException;
import com.hackathon.bankapplication.model.Customer;
import com.hackathon.bankapplication.model.FavouriteAccount;
import com.hackathon.bankapplication.repository.CustomerDao;
import com.hackathon.bankapplication.repository.FavouriteAccountDao;
import com.hackathon.bankapplication.vo.AccountIbanNoVo;

@Service
public class FavouriteAccountServiceImpl implements FavouriteAccountService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	FavouriteAccountDao favouriteAccountDao;

    private static final Logger log = LoggerFactory.getLogger(FavouriteAccountServiceImpl.class);

	@Override
	public Long addFavouriteAccount(@Valid FavouriteAccount favouriteAccount, Long customerId) {
		log.info("adding favourite accounts service class");

		Optional<Customer> customer = customerDao.findById(customerId);
		Customer customer1 = null;
		String uri = "http://localhost:8085/bank/getbankname";
		RestTemplate restTemplate = new RestTemplate();
		AccountIbanNoVo accountIbanNoVo = new AccountIbanNoVo(favouriteAccount.getFavouriteAccountIBanNumber());
		String bankName = restTemplate.postForObject(uri, accountIbanNoVo, String.class);
		if (!bankName.isEmpty()) {
			favouriteAccount.setFavouriteBankName(bankName);
		}
		if (customer.isPresent()) {
			customer1 = customer.get();
		}
		favouriteAccount.setCustomer(customer1);
		FavouriteAccount favouriteAccount2 = favouriteAccountDao.save(favouriteAccount);
		return favouriteAccount2.getFavouriteAccountId();
	}

	@Override
	public void deleteFavouriteAccount(String favouriteAccountIbanNumber, Long customerId) {
		
		log.info("deleting the favourite account -service class");

		
		if (favouriteAccountIbanNumber != null && favouriteAccountDao.existsByFavouriteAccountIBanNumber(favouriteAccountIbanNumber) && customerDao.existsById(customerId) ) {
			
			Optional<Customer> customer = customerDao.findById(customerId);
			/*
			 * Customer customer1 = null; if (customer.isPresent()) { customer1 =
			 * customer.get(); }
			 */
			 
			
			favouriteAccountDao.deleteByFavouriteAccountIBanNumberAndCustomer(favouriteAccountIbanNumber,customerId);
		} else {
			throw new RecordNotFoundException((favouriteAccountIbanNumber == null ? "No Id is provided!!"
					: "favourite Account  '" + favouriteAccountIbanNumber + "' not exist"));

		}
	}

	@Override
	public void updateFavouriteAccount(@Valid FavouriteAccount favouriteAccount, Long customerId) {
		log.info("upadating the favourite account details -service class");
		if (favouriteAccount.getFavouriteAccountId() != null
				&& favouriteAccountDao.existsById(favouriteAccount.getFavouriteAccountId()) && customerDao.existsById(customerId)) {
			
			Optional<Customer> customer=customerDao.findById(customerId);
			Customer customer1 = null;
			if(customer.isPresent())
			{
				customer1=customer.get();
			}
			favouriteAccount.setCustomer(customer1);

			favouriteAccountDao.save(favouriteAccount);
		} else {
			throw new RecordNotFoundException((favouriteAccount.getFavouriteAccountId() == null ? "No Id is provided!!"
					: "favourite Account  '" + favouriteAccount.getFavouriteAccountId() + "' not exist"));

		}
	}

	@Override
	public List<FavouriteAccount> getFavouriteAccounts(Long customerId, Pageable pageable) {
		log.info("list all favourite account details -service class");

		Optional<Customer> customer = customerDao.findById(customerId);

		Page<FavouriteAccount> favouriteAccounts = favouriteAccountDao.findByCustomer(customer.get(), pageable); 																								// repo.findAll(pageable)
		if (favouriteAccounts.hasContent()) {
			return favouriteAccounts.getContent();
		} else {
			return new ArrayList<FavouriteAccount>();
		}
	}

	@Override
	public FavouriteAccount getFavouriteAccount(Long favouriteAccountId) {
		FavouriteAccount favouriteAccount1=null;
		Optional<FavouriteAccount> favouriteAccount =favouriteAccountDao.findById(favouriteAccountId);
		if(favouriteAccount.isPresent())
		{
			favouriteAccount1=favouriteAccount.get();
		}
		else {
			throw new RecordNotFoundException("no favourite account found");
		}
		return favouriteAccount1;
	}

}
