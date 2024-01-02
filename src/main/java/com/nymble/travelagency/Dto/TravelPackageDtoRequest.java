package com.nymble.travelagency.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageDtoRequest {
    private String packageName; // name of package
    private int packageCapacity; // passenger capacity of the package
}
