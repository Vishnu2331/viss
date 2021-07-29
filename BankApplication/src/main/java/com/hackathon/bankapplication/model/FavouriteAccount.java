package com.hackathon.bankapplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favourite_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteAccount {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long favouriteAccountId;
    @NotEmpty(message = "favourite Account Name should not be empty")
    private String favouriteAccountName;
    @NotEmpty(message = "favourite Account IbanNumber should not be empty")
    @Column(unique = true)
    private String favouriteAccountIBanNumber;
    @NotEmpty(message = "favourite Account Bank Name should not be empty")
    private String favouriteBankName;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
	
}
