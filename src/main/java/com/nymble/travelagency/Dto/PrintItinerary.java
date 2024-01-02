package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintItinerary {

    private String packageName; // name of package
    private List<DestinationActivity> destinationActivities ;// list of activities under the package

}
