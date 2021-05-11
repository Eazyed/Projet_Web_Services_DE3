package de3.webservices.back.timeservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dates {
	private @Id Date Date;
	private long WeekNum;
	private long MonthNum;
	public Dates(java.sql.Date date, long weekNum, long monthNum) {
		super();
		Date = date;
		WeekNum = weekNum;
		MonthNum = monthNum;
	}
	public Dates() {
		super();
	}
	
	
}
