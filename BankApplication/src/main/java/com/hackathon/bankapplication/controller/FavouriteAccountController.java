package com.hackathon.bankapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.bankapplication.exception.RecordNotFoundException;
import com.hackathon.bankapplication.model.FavouriteAccount;
import com.hackathon.bankapplication.service.FavouriteAccountService;

@RestController
@RequestMapping("/{customerId}/favouriteaccount")
public class FavouriteAccountController {

	@Autowired
	FavouriteAccountService favouriteAccountService;
	
	private static final Logger log = LoggerFactory.getLogger(FavouriteAccountController.class);

	@PostMapping
	public ResponseEntity<String> addFavouriteAccount(@PathVariable("customerId") Long customerId, @Valid @RequestBody FavouriteAccount favouriteAccount) {
		log.info("adding favourite account");
		try {
			String message=null;
			Long id=favouriteAccountService.addFavouriteAccount(favouriteAccount,customerId);
			if(id>0) {
			 message="favourite account with "+id+" added";
			}
			else
			{
				message="account creation failed";
			}
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<String> updateFavouriteAccount(@PathVariable("customerId") Long customerId,@Valid @RequestBody FavouriteAccount favouriteAccount) {
		log.info("upadating the favourite account details");
		ResponseEntity<String> response=null;		
		
			
			favouriteAccountService.updateFavouriteAccount(favouriteAccount,customerId);
			String message="favourite account with "+favouriteAccount.getFavouriteAccountId()+" updated";
			response= new ResponseEntity<>(message, HttpStatus.CREATED);
		
		return response;
	}
	
	@DeleteMapping("/{favouriteAccountIBanNumber}")
	public ResponseEntity<String> deleteFavouriteAccount(@PathVariable("favouriteAccountIBanNumber") String favouriteAccountIBanNumber,@PathVariable("customerId") Long customerId) {
		log.info("deleting the favourite account ");

		ResponseEntity<String> response=null;
			favouriteAccountService.deleteFavouriteAccount(favouriteAccountIBanNumber,customerId);
			String message="favourite account with "+favouriteAccountIBanNumber+" deleted";
			response=new ResponseEntity<>(message, HttpStatus.OK);
		return response;
	}
	@GetMapping
	public ResponseEntity<List<FavouriteAccount>> getFavouriteAccounts(@PathVariable("customerId") Long customerId,
			 @RequestParam(required = false,defaultValue = "0",value = "pageId") Integer pageId,
			 @RequestParam(required = false,defaultValue = "4",value = "pageSize") Integer pageSize,
			@RequestParam(required = false,defaultValue = "favouriteAccountName",value = "columnName") String columnName) {
		log.info("list of all favourite account details");

		ResponseEntity<List<FavouriteAccount>> response =null;
		
		
			 Pageable pageable=PageRequest.of(pageId, pageSize,Sort.by(columnName).ascending());
			List<FavouriteAccount> favouriteAccounts=favouriteAccountService.getFavouriteAccounts(customerId,pageable);
			
			response=new ResponseEntity<>(favouriteAccounts, HttpStatus.OK);
	
		return response; 
	}
	
	@GetMapping("/{favouriteAccountId}")
	public ResponseEntity<FavouriteAccount> getFavouriteAccount(@PathVariable("favouriteAccountId") Long favouriteAccountId) {
		log.info("deleting the favourite account ");

		ResponseEntity<FavouriteAccount> response=null;
		
		
			FavouriteAccount favouriteAccount=favouriteAccountService.getFavouriteAccount(favouriteAccountId);
			
			response=new ResponseEntity<>(favouriteAccount, HttpStatus.OK);
		
		
		return response;
	}
}
