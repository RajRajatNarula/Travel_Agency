package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDto {

    private String destinationName; // name of destination
    private long packageId; // package Id under which this destination comes
}
