package com.hcl.airport_management_system_server.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pilot1000")

public class Pilot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private long pilotId;
	private String pilotFirstName;
	private String pilotLastName;
	private int pilotAge;
	@Enumerated(EnumType.STRING)
	private Gender pilotGender;
	private long pilotContactNumber;

	@JsonIgnore
	@OneToOne(targetEntity = Aeroplane.class, cascade = CascadeType.ALL)
	private Aeroplane address;

	public Pilot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pilot(long pilotId, String pilotFirstName, String pilotLastName, int pilotAge, Gender pilotGender,
			long pilotContactNumber) {
		super();
		this.pilotId = pilotId;
		this.pilotFirstName = pilotFirstName;
		this.pilotLastName = pilotLastName;
		this.pilotAge = pilotAge;
		this.pilotGender = pilotGender;
		this.pilotContactNumber = pilotContactNumber;
	}

	public Pilot(String pilotFirstName, String pilotLastName, int pilotAge, Gender pilotGender,
			long pilotContactNumber) {
		super();
		this.pilotFirstName = pilotFirstName;
		this.pilotLastName = pilotLastName;
		this.pilotAge = pilotAge;
		this.pilotGender = pilotGender;
		this.pilotContactNumber = pilotContactNumber;
	}

	public Pilot(long pilotId, String pilotFirstName, String pilotLastName, int pilotAge, Gender pilotGender,
			long pilotContactNumber, Aeroplane address) {
		super();
		this.pilotId = pilotId;
		this.pilotFirstName = pilotFirstName;
		this.pilotLastName = pilotLastName;
		this.pilotAge = pilotAge;
		this.pilotGender = pilotGender;
		this.pilotContactNumber = pilotContactNumber;
		this.address = address;
	}

	public long getPilotId() {
		return pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotFirstName() {
		return pilotFirstName;
	}

	public void setPilotFirstName(String pilotFirstName) {
		this.pilotFirstName = pilotFirstName;
	}

	public String getPilotLastName() {
		return pilotLastName;
	}

	public void setPilotLastName(String pilotLastName) {
		this.pilotLastName = pilotLastName;
	}

	public int getPilotAge() {
		return pilotAge;
	}

	public void setPilotAge(int pilotAge) {
		this.pilotAge = pilotAge;
	}

	public Gender getPilotGender() {
		return pilotGender;
	}

	public void setPilotGender(Gender pilotGender) {
		this.pilotGender = pilotGender;
	}

	public long getPilotContactNumber() {
		return pilotContactNumber;
	}

	public void setPilotContactNumber(long pilotContactNumber) {
		this.pilotContactNumber = pilotContactNumber;
	}

	public Aeroplane getAddress() {
		return address;
	}

	public void setAddress(Aeroplane address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pilot [pilotId=" + pilotId + ", pilotFirstName=" + pilotFirstName + ", pilotLastName=" + pilotLastName
				+ ", pilotAge=" + pilotAge + ", pilotGender=" + pilotGender + ", pilotContactNumber="
				+ pilotContactNumber + ", address=" + address + "]";
	}

}
