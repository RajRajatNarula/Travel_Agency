package com.nymble.travelagency.Service.impl;

import com.nymble.travelagency.Dto.ActivitiesSignUp;
import com.nymble.travelagency.Dto.ActivityDto;
import com.nymble.travelagency.Dto.PassengerDto;
import com.nymble.travelagency.Entities.Activity;
import com.nymble.travelagency.Entities.Passenger;
import com.nymble.travelagency.Entities.PassengerActivity;
import com.nymble.travelagency.Entities.TravelPackage;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Mapper.PassengerMapper;
import com.nymble.travelagency.Respository.*;
import com.nymble.travelagency.Service.PassengerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private static final Logger logger = LoggerFactory.getLogger(PassengerServiceImpl.class);

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final TravelPackageRespository travelPackageRespository;
    private final DestinationRepository destinationRepository;
    private final PassActRepository passActRepository;
    private final ActivitiesRepository activitiesRepository;

    //method to insert new passenger details
    public PassengerDto insertPassenger(PassengerDto passengerDto) throws UserDefinedException {
        logger.info("Entered insertPassenger of PassengerServiceImpl");
        TravelPackage travelPackage=travelPackageRespository.findByPackageName(passengerDto.getTravelPackageName());
        if(travelPackage==null)
        {
            throw new UserDefinedException("Travel package data not found");
        }
        int capacity=travelPackage.getPassengerSlotLeft();
        //checking if slots are left for a particular package
        if(capacity<=0)
        {
            throw new UserDefinedException("No Capacity");
        }
        //setting values
        travelPackage.setPassengerSlotLeft(capacity-1);
        travelPackageRespository.save(travelPackage);
        Passenger passenger=new Passenger();
        passenger.setPassengerName(passengerDto.getPassengerName());
        passenger.setMembership(passengerDto.getMembership());
        passenger.setBalance(passengerDto.getBalance());
        passenger.setPassengerNumber(passengerDto.getPassengerNumber());
        //checking if this passenger already bought this package
        Passenger passenger1= passengerRepository.findBySameNameAndPackage(passengerDto.getPassengerName(), travelPackage.getPackageId());

        if(passenger1!=null)
        {
            throw new UserDefinedException("Already registered with this package");
        }


        passenger.setTravelPackage(travelPackage);

        passengerRepository.save(passenger);
        return passengerDto;
    }

    //method to get all passengers
    public List<PassengerDto> getAllPassenger() {
        logger.info("Entered getAllPassenger of PassengerServiceImpl");
        return passengerRepository.findAll().stream().map(passengerMapper :: mapPassengerToPassengerDto).collect(Collectors.toList());

    }


    //method to signup for new activity
    public ActivitiesSignUp signUp(ActivitiesSignUp activitiesSignUp) throws UserDefinedException {
        logger.info("Entered signUp");
        //retrieving passenger details
        Passenger passenger=passengerRepository.findByPassengerId(activitiesSignUp.getPassengerId());
        if(passenger==null)
        {
            throw new UserDefinedException("Passenger not found");
        }
        // getting list of all destinations where passenger can do activities
        List<Long> destIds=destinationRepository.findByPackId(passenger.getTravelPackage().getPackageId());
        if(destIds.size()==0)
        {
            throw new UserDefinedException("No destinations under this package");
        }
        // checking if passenger has balance left to sign up for a acitvity
        double balance=passenger.getBalance();
        if(balance>0)
        {

            for(ActivityDto activityDto:activitiesSignUp.getActivityList())
            {
                long destId=activityDto.getDestinationId();
                PassengerActivity passengerActivity=new PassengerActivity();
                //checking if the activity that passenger wants comes under package or not
                if(destIds.contains(destId))
                {
                    // it comes under  package
                    //getting details of the activity
                    Activity activity=activitiesRepository.findByActivityName(activityDto.getActivityName());
                    if(activity==null)
                    {
                        throw new UserDefinedException("Activity not found");
                    }
                    // checking if passenger has enough balance for this activity and activity has slots left
                    if(balance-activityDto.getActivityCost()>=0 && activity.getCapacity()>0)
                    {

                        double pricePaid=0;
                        // if passenger membership is gold then 10% discount on activity price
                        if(passenger.getMembership().equalsIgnoreCase("gold")) {
                            pricePaid=((activityDto.getActivityCost() / 100) * 90);
                            balance = balance - pricePaid;

                        }
                        //if passenger is standard ,has to pay full for activity
                           else if (passenger.getMembership().equalsIgnoreCase("standard")) {
                            pricePaid=activityDto.getActivityCost();
                            balance = balance - pricePaid;
                        }
                           // if premium then can sign up for free
                        passengerActivity.setPassengerId(passenger.getPassengerId());
                        passengerActivity.setActivityName(activityDto.getActivityName());
                        passengerActivity.setPrice(pricePaid);
                        String destinatioName=destinationRepository.findByDestId(activityDto.getDestinationId());
                        if(destinatioName.isEmpty())
                        {
                            throw new UserDefinedException("Destination name not found");
                        }
                        passengerActivity.setDestination(destinatioName);
                        passActRepository.save(passengerActivity);

                        activity.setSlotsLeft(activity.getCapacity()-1);
                        activitiesRepository.save(activity);

                    }
                    else {
                        // passenger doesnt have sufficient balance
                        throw new RuntimeException("INSUFFICIENT BALANCE");
                    }
                }
                else {
                    // this activity or destination doesnt come under passenger's chosen package
                    throw new RuntimeException("CANNOT SELECT THIS ACTIVITY IN THIS PACKAGE");
                }

            }
        }

        passenger.setBalance(balance);
        passengerRepository.save(passenger);

    return  activitiesSignUp;
    }
}
