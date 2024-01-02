package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationActivity {

    private String destinationName; // name of destination
    private List<ActivityDto> activity; // list of activities

}
