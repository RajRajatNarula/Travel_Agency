package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintPassengerInd {

    private String  passengerName; // name of passenger
    private String  passengerNumber; // phone number of passenger
    private double  passengerBalance;// balance left with passenger
    private List<String> activityDetails; // activity name : destination name : pricepaid for activity

}
