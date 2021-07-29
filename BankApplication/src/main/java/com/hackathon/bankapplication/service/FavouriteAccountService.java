package com.hackathon.bankapplication.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;

import com.hackathon.bankapplication.model.FavouriteAccount;

public interface FavouriteAccountService {

	Long addFavouriteAccount(@Valid FavouriteAccount favouriteAccount, Long customerId);

	void deleteFavouriteAccount(String favouriteAccountId, Long customerId);

	void updateFavouriteAccount(@Valid FavouriteAccount favouriteAccount, Long customerId);

	List<FavouriteAccount> getFavouriteAccounts(Long customerId,Pageable pageable);

	FavouriteAccount getFavouriteAccount(Long favouriteAccountId);

}
