package com.nymble.travelagency.Service;

import com.nymble.travelagency.Dto.TravelPackageDtoRequest;
import com.nymble.travelagency.Entities.TravelPackage;

import java.util.List;

public interface TravelPackageService {

    TravelPackageDtoRequest insertPackage(TravelPackageDtoRequest travelPackageDtoRequest);
    List<TravelPackage> getAllPackages();
}
