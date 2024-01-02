package com.nymble.travelagency.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrintPassenger {

    private String packageName; //name of travel package
    private int capacity; // capacity of that package
    private int passengersEnrolled; // number of passengers enrolled in the package
    private List<String> nameNumber; // Name and number of the package seperated by " : "

}
