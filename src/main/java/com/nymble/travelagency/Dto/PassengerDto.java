package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private String passengerName; // name of the passenger
    private String passengerNumber; // phone number of passenger
    private String membership; // type of membership the passenger has
    private double balance; // balance of the passenger
    private String travelPackageName; // travel package the passenger took
}
