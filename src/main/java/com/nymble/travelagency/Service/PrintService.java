package com.nymble.travelagency.Service;

import com.nymble.travelagency.Dto.ActivityLeft;
import com.nymble.travelagency.Dto.PrintItinerary;
import com.nymble.travelagency.Dto.PrintPassenger;
import com.nymble.travelagency.Dto.PrintPassengerInd;
import com.nymble.travelagency.Exception.UserDefinedException;

import java.util.List;

public interface PrintService {
    PrintItinerary getItinerary(long packageId) throws UserDefinedException;
    PrintPassenger getPassengersDetail(long packageId) throws UserDefinedException;
    PrintPassengerInd getOnePassenger(long passId) throws UserDefinedException;
    List<ActivityLeft> getAvailableActs() throws UserDefinedException;
}
