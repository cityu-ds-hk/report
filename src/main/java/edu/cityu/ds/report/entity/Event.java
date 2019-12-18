package edu.cityu.ds.report.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by starice on 2019-12-18.
 */
@Getter
@Setter
@NoArgsConstructor
public class Event {
	
	private Integer eventId;
	
	private Integer groupId;
	
	private String description;
	
	private Integer duration;
	
	private String eventName;
	
	private Timestamp eventTime;
	
	private Integer venueId;
	
	private Timestamp created;
	
	private Timestamp updated;
	
}
