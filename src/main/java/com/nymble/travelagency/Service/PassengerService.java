package com.nymble.travelagency.Service;


import com.nymble.travelagency.Dto.ActivitiesSignUp;
import com.nymble.travelagency.Dto.PassengerDto;
import com.nymble.travelagency.Exception.UserDefinedException;

import java.util.List;

public interface PassengerService {
    PassengerDto insertPassenger(PassengerDto passengerDto) throws UserDefinedException;
    List<PassengerDto> getAllPassenger();
    ActivitiesSignUp signUp(ActivitiesSignUp activitiesSignUp) throws UserDefinedException;

}
