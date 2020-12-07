package com.hcl.airport_management_system_server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin1000")
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	private String adminEmail;
	private String adminFirstName;
	private String adminLastName;
	private int adminAge;
	@Enumerated(EnumType.STRING)
	private Gender adminGender;
	private long adminContactNumber;
	private String adminPassword;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(long adminId, String adminEmail, String adminFirstName, String adminLastName, int adminAge,
			Gender adminGender, long adminContactNumber, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminContactNumber = adminContactNumber;
		this.adminPassword = adminPassword;
	}

	public Admin(String adminEmail, String adminFirstName, String adminLastName, int adminAge, Gender adminGender,
			long adminContactNumber, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminAge = adminAge;
		this.adminGender = adminGender;
		this.adminContactNumber = adminContactNumber;
		this.adminPassword = adminPassword;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public int getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(int adminAge) {
		this.adminAge = adminAge;
	}

	public Gender getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(Gender adminGender) {
		this.adminGender = adminGender;
	}

	public long getAdminContactNumber() {
		return adminContactNumber;
	}

	public void setAdminContactNumber(long adminContactNumber) {
		this.adminContactNumber = adminContactNumber;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminFirstName=" + adminFirstName
				+ ", adminLastName=" + adminLastName + ", adminAge=" + adminAge + ", adminGender=" + adminGender
				+ ", adminContactNumber=" + adminContactNumber + ", adminPassword=" + adminPassword + "]";
	}

}
