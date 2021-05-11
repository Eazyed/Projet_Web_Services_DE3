package de3.webservices.back.timeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class TimeSlot {
	
	public @Id @GeneratedValue Long IdSlot;
	
	public Long HourCount;
	public Long IdUser;
	public Long IdProject;
	@ManyToOne
	public Dates ReferredDate;
}
