package edu.cityu.ds.report.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Topic {

    private Integer topicId;

    private String topicName;

    private Integer mainTopicId;

    private Integer members;
}
