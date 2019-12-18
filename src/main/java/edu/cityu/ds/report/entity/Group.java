package edu.cityu.ds.report.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * Created by starice on 2019-12-18.
 */

@Schema(name = "Group Entity")
@Getter
@Setter
@NoArgsConstructor
public class Group {

	private Integer groupId;
	
	private Integer categoryId;
	
	private Integer cityId;
	
	private Integer members;
	
	private String groupName;
	
	private Integer organizerMemberId;
	
	private Double rating;
	
	private String visibility;
	
	private String who;
	
	private Timestamp created;
}
