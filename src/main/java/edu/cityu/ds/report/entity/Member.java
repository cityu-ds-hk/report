package edu.cityu.ds.report.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Member {

    private Integer memberId;

    private Integer cityId;

    private String memberName;

    private String memberStatus;

    private Timestamp created;
}
