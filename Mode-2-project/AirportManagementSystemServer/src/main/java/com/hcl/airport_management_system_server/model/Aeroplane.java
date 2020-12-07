package com.hcl.airport_management_system_server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aeroplane1000")
public class Aeroplane implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aeroplaneId;
	private String aeroplaneName;
	private String aeroplaneCompanyName;
	private String aeroplaneHangerStatus;
	private String aeroplanePilotStatus;

	@JsonIgnore
	@OneToOne(targetEntity = Pilot.class)
	private Pilot pilot;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "hangerId", nullable = true)
	private Hanger hanger;

	public Aeroplane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aeroplane(String aeroplaneName, String aeroplaneCompanyName, String aeroplaneHangerStatus,
			String aeroplanePilotStatus) {
		super();
		this.aeroplaneName = aeroplaneName;
		this.aeroplaneCompanyName = aeroplaneCompanyName;
		this.aeroplaneHangerStatus = aeroplaneHangerStatus;
		this.aeroplanePilotStatus = aeroplanePilotStatus;
	}

	public Aeroplane(long aeroplaneId, String aeroplaneName, String aeroplaneCompanyName, String aeroplaneHangerStatus,
			String aeroplanePilotStatus) {
		super();
		this.aeroplaneId = aeroplaneId;
		this.aeroplaneName = aeroplaneName;
		this.aeroplaneCompanyName = aeroplaneCompanyName;
		this.aeroplaneHangerStatus = aeroplaneHangerStatus;
		this.aeroplanePilotStatus = aeroplanePilotStatus;
	}

	public Aeroplane(long aeroplaneId, String aeroplaneName, String aeroplaneCompanyName, String aeroplaneHangerStatus,
			String aeroplanePilotStatus, Pilot pilot) {
		super();
		this.aeroplaneId = aeroplaneId;
		this.aeroplaneName = aeroplaneName;
		this.aeroplaneCompanyName = aeroplaneCompanyName;
		this.aeroplaneHangerStatus = aeroplaneHangerStatus;
		this.aeroplanePilotStatus = aeroplanePilotStatus;
		this.pilot = pilot;
	}

	public Aeroplane(long aeroplaneId, String aeroplaneName, String aeroplaneCompanyName, String aeroplaneHangerStatus,
			String aeroplanePilotStatus, Pilot pilot, Hanger hanger) {
		super();
		this.aeroplaneId = aeroplaneId;
		this.aeroplaneName = aeroplaneName;
		this.aeroplaneCompanyName = aeroplaneCompanyName;
		this.aeroplaneHangerStatus = aeroplaneHangerStatus;
		this.aeroplanePilotStatus = aeroplanePilotStatus;
		this.pilot = pilot;
		this.hanger = hanger;
	}

	public long getAeroplaneId() {
		return aeroplaneId;
	}

	public void setAeroplaneId(long aeroplaneId) {
		this.aeroplaneId = aeroplaneId;
	}

	public String getAeroplaneName() {
		return aeroplaneName;
	}

	public void setAeroplaneName(String aeroplaneName) {
		this.aeroplaneName = aeroplaneName;
	}

	public String getAeroplaneCompanyName() {
		return aeroplaneCompanyName;
	}

	public void setAeroplaneCompanyName(String aeroplaneCompanyName) {
		this.aeroplaneCompanyName = aeroplaneCompanyName;
	}

	public String getAeroplaneHangerStatus() {
		return aeroplaneHangerStatus;
	}

	public void setAeroplaneHangerStatus(String aeroplaneHangerStatus) {
		this.aeroplaneHangerStatus = aeroplaneHangerStatus;
	}

	public String getAeroplanePilotStatus() {
		return aeroplanePilotStatus;
	}

	public void setAeroplanePilotStatus(String aeroplanePilotStatus) {
		this.aeroplanePilotStatus = aeroplanePilotStatus;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Hanger getHanger() {
		return hanger;
	}

	public void setHanger(Hanger hanger) {
		this.hanger = hanger;
	}

	@Override
	public String toString() {
		return "Aeroplane [aeroplaneId=" + aeroplaneId + ", aeroplaneName=" + aeroplaneName + ", aeroplaneCompanyName="
				+ aeroplaneCompanyName + ", aeroplaneHangerStatus=" + aeroplaneHangerStatus + ", pilot=" + pilot + "]";
	}

}
