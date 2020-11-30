package com.hcl.pp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PETS")
public class Pet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	@Column(name = "PET_NAME")
	private String petName;
	@Column(name="PET_AGE")
	private int petAge;
	@Column(name = "PET_PLACE")
	private String petPlace;
	@ManyToOne
	@JoinColumn(name="PET_OWNERID", nullable=true)
    private User owner;
	public Pet() {
		super();
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	public String getPetPlace() {
		return petPlace;
	}
	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}
	public User getOwner() {
		return owner;
	}
	public void setUser(User owner) {
		this.owner = owner;
	}

	

}
