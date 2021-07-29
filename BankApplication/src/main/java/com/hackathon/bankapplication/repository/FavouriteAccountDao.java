package com.hackathon.bankapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hackathon.bankapplication.model.Customer;
import com.hackathon.bankapplication.model.FavouriteAccount;

public interface FavouriteAccountDao extends PagingAndSortingRepository<FavouriteAccount, Long> {

	
	public Page<FavouriteAccount> findByCustomer(Customer customer,Pageable pageable);

	public boolean existsByFavouriteAccountIBanNumber(String favouriteAccountIbanNumber);
    
	
	//public void deleteByFavouriteAccountIBanNumberAndCustomer(String favouriteAccountIbanNumber, Customer customer);
   @Query(value="delete from favourite_account where favourite_accountiban_number=:favouriteAccountIbanNumber and customer_id=:customerId",nativeQuery = true)
	public void deleteByFavouriteAccountIBanNumberAndCustomer(String favouriteAccountIbanNumber, Long customerId);

	
	
}
