package com.hcl.airport_management_system_server.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hanger1000")
public class Hanger implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hangerId;
	private String hangerName;
	private int hangerCapacity;
	private int hangerAvailability;

	@JsonIgnore
	@OneToMany(mappedBy = "hanger")
	private Set<Aeroplane> aeroplanes;

	public Hanger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hanger(String hangerName, int hangerCapacity, int hangerAvailability) {
		super();
		this.hangerName = hangerName;

		this.hangerCapacity = hangerCapacity;
		;
		this.hangerAvailability = hangerAvailability;
	}

	public Hanger(long hangerId, String hangerName, int hangerCapacity, int hangerAvailability) {
		super();
		this.hangerId = hangerId;
		this.hangerName = hangerName;
		this.hangerCapacity = hangerCapacity;
		this.hangerAvailability = hangerAvailability;
	}

	public Hanger(long hangerId, String hangerName, int hangerCapacity, Set<Aeroplane> aeroplanes,
			int hangerAvailability) {
		super();
		this.hangerId = hangerId;
		this.hangerName = hangerName;
		this.hangerCapacity = hangerCapacity;
		this.aeroplanes = aeroplanes;
		this.hangerAvailability = hangerAvailability;
	}

	public long getHangerId() {
		return hangerId;
	}

	public void setHangerId(long hangerId) {
		this.hangerId = hangerId;
	}

	public String getHangerName() {
		return hangerName;
	}

	public void setHangerName(String hangerName) {
		this.hangerName = hangerName;
	}

	public int getHangerCapacity() {
		return hangerCapacity;
	}

	public void setHangerCapacity(int hangerCapacity) {
		this.hangerCapacity = hangerCapacity;
	}

	public Set<Aeroplane> getAeroplanes() {
		return aeroplanes;
	}

	public void setAeroplanes(Set<Aeroplane> aeroplanes) {
		this.aeroplanes = aeroplanes;
	}

	public int getHangerAvailability() {
		return hangerAvailability;
	}

	public void setHangerAvailability(int hangerAvailability) {
		this.hangerAvailability = hangerAvailability;
	}

	@Override
	public String toString() {
		return "Hanger [hangerId=" + hangerId + ", hangerName=" + hangerName + ", hangerCapacity=" + hangerCapacity
				+ ", hangerAvailability=" + hangerAvailability + ", aeroplanes=" + aeroplanes + "]";
	}

}
