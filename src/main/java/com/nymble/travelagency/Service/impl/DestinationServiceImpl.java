package com.nymble.travelagency.Service.impl;

import com.nymble.travelagency.Dto.DestinationDto;
import com.nymble.travelagency.Entities.Destination;
import com.nymble.travelagency.Entities.TravelPackage;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Mapper.DestinationMapper;
import com.nymble.travelagency.Respository.DestinationRepository;
import com.nymble.travelagency.Respository.TravelPackageRespository;
import com.nymble.travelagency.Service.DestinationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private static final Logger logger = LoggerFactory.getLogger(DestinationServiceImpl.class);

    private final DestinationRepository destinationRepository;
    private final TravelPackageRespository travelPackageRespository;
    private final DestinationMapper destinationMapper;
   // method to insert destination details
    public DestinationDto insertDestination(DestinationDto destinationdto) throws UserDefinedException {
        logger.info("Entered insertDestination of DestinationServiceImpl");
        Destination destination=new Destination();
        //settind values in  destination from destinationDto
        destination.setDestinationName(destinationdto.getDestinationName());
        TravelPackage travelPackage=travelPackageRespository.findByPackageId(destinationdto.getPackageId());
        if(travelPackage == null)
        {
            throw new UserDefinedException("Travel Package Does not exist");
        }
        destination.setTravelPackage(travelPackage);
        destinationRepository.save(destination);
        return  destinationdto;
    }

    // method to retrive all destinations records
    public List<Destination> getAllDestination() {
        logger.info("Entered getAllDestination of DestinationServiceImpl");
        return destinationRepository.findAll();
    }
}
