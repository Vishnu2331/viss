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
@Table(name = "manager1000")
public class Manager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long managerId;
	private String managerEmail;
	private String managerFirstName;
	private String managerLastName;
	private String managerAge;
	@Enumerated(EnumType.STRING)
	private Gender managerGender;
	private long managerContactNumber;
	private String managerPassword;
	private String managerStatus;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String managerEmail, String managerFirstName, String managerLastName, String managerAge,
			Gender managerGender, long managerContactNumber, String managerPassword) {
		super();
		this.managerEmail = managerEmail;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerAge = managerAge;
		this.managerGender = managerGender;
		this.managerContactNumber = managerContactNumber;
		this.managerPassword = managerPassword;
	}

	public Manager(String managerEmail, String managerFirstName, String managerLastName, String managerAge,
			Gender managerGender, long managerContactNumber, String managerPassword, String managerStatus) {
		super();
		this.managerEmail = managerEmail;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerAge = managerAge;
		this.managerGender = managerGender;
		this.managerContactNumber = managerContactNumber;
		this.managerPassword = managerPassword;
		this.managerStatus = managerStatus;
	}

	public Manager(long managerId, String managerEmail, String managerFirstName, String managerLastName,
			String managerAge, Gender managerGender, long managerContactNumber, String managerPassword,
			String managerStatus) {
		super();
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerAge = managerAge;
		this.managerGender = managerGender;
		this.managerContactNumber = managerContactNumber;
		this.managerPassword = managerPassword;
		this.managerStatus = managerStatus;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public String getManagerAge() {
		return managerAge;
	}

	public void setManagerAge(String managerAge) {
		this.managerAge = managerAge;
	}

	public Gender getManagerGender() {
		return managerGender;
	}

	public void setManagerGender(Gender managerGender) {
		this.managerGender = managerGender;
	}

	public long getManagerContactNumber() {
		return managerContactNumber;
	}

	public void setManagerContactNumber(long managerContactNumber) {
		this.managerContactNumber = managerContactNumber;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerStatus() {
		return managerStatus;
	}

	public void setManagerStatus(String managerStatus) {
		this.managerStatus = managerStatus;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerEmail=" + managerEmail + ", managerFirstName="
				+ managerFirstName + ", managerLastName=" + managerLastName + ", managerAge=" + managerAge
				+ ", managerGender=" + managerGender + ", managerContactNumber=" + managerContactNumber
				+ ", managerPassword=" + managerPassword + ", managerStatus=" + managerStatus + "]";
	}

}
