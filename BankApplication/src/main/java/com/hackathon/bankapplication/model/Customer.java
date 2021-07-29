package com.hackathon.bankapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long customerId;
   
    @NotNull(message = "Customer Name Can not be Null")
	private String customerName;
    @NotNull(message = "Customer Email Can not be Null")
    @Email
	private String customerEmail;
    @NotNull(message = "Customer Ph Number Can not be Null")
   
	private Integer customerPhoneNumber;
    @NotNull(message = "Customer Password Can not be Null")
    @Size(min = 8,message = "Passoword must be alteast 8 digits")
	private String customerPassword;
	
}
