package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    private String activityName;// name of activity
    private String description;// description about activity
    private double activityCost;// cost of the activity
    private int capacity; // capacity of that activity
    private long destinationId; // Id destination at which this activity will happen
}
