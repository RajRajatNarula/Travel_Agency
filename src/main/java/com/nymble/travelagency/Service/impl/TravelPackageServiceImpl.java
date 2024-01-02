package com.nymble.travelagency.Service.impl;

import com.nymble.travelagency.Dto.TravelPackageDtoRequest;
import com.nymble.travelagency.Entities.TravelPackage;
import com.nymble.travelagency.Respository.TravelPackageRespository;

import com.nymble.travelagency.Service.TravelPackageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TravelPackageServiceImpl implements TravelPackageService {
    private static final Logger logger = LoggerFactory.getLogger(TravelPackageServiceImpl.class);

    private final TravelPackageRespository travelPackageRespository;

    // method to insert new package details
    public TravelPackageDtoRequest insertPackage(TravelPackageDtoRequest travelPackageDtoRequest) {

        logger.info("Entered insertPackage of TravelPackageService");
        TravelPackage travelPackage=new TravelPackage();
        travelPackage.setPackageName(travelPackageDtoRequest.getPackageName());
        travelPackage.setPassengerCapacity(travelPackageDtoRequest.getPackageCapacity());
        travelPackage.setPassengerSlotLeft(travelPackage.getPassengerCapacity());
        travelPackageRespository.save(travelPackage);
        return travelPackageDtoRequest;
    }

    // method to get list of all packages
    public List<TravelPackage> getAllPackages() {
        logger.info("Entered getAllPackages of TravelPackageService");
        return travelPackageRespository.findAll();

    }
}
