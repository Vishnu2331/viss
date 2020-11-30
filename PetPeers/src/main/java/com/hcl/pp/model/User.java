package com.hcl.pp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PET_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "USER_EMAIL")
	private String userEmail;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
    @OneToMany(mappedBy = "owner")
	private Set<Pet> pets;

	public User() {
		super();
	}

	public User(Long userId, String userEmail, String userPassword, Set<Pet> pets) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;

		this.pets = pets;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userName) {
		this.userEmail = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
