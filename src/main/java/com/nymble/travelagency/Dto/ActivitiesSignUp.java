package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ActivitiesSignUp {

    private Long passengerId; // passengers id
    private List<ActivityDto> activityList; // list of passengers

}
