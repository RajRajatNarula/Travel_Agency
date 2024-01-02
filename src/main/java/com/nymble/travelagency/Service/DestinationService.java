package com.nymble.travelagency.Service;

import com.nymble.travelagency.Dto.DestinationDto;
import com.nymble.travelagency.Entities.Destination;
import com.nymble.travelagency.Exception.UserDefinedException;

import java.util.List;

public interface DestinationService {
    DestinationDto insertDestination(DestinationDto destinationdto) throws UserDefinedException;
    List<Destination> getAllDestination();
}
