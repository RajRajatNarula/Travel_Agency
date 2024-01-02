package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLeft {

    private String activityName; // name of activity
    private String activityCost; // cost of that activity
    private String destination; // destination name of that activity
    private String spacesLeft; // slots left for that activity
}
