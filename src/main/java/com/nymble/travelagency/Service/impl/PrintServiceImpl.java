package com.nymble.travelagency.Service.impl;

import com.nymble.travelagency.Dto.*;
import com.nymble.travelagency.Entities.*;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Mapper.MapperActivity;
import com.nymble.travelagency.Respository.*;
import com.nymble.travelagency.Service.PrintService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrintServiceImpl implements PrintService {
    private static final Logger logger = LoggerFactory.getLogger(PrintServiceImpl.class);

    private final TravelPackageRespository travelPackageRespository;
    private final ActivitiesRepository activitiesRepository;
    private final DestinationRepository destinationRepository;
    private final MapperActivity mapperActivity;
    private final PassengerRepository passengerRepository;
    private final PassActRepository passActRepository;



    // method to get itinerary of a particular package
    public PrintItinerary getItinerary(long packageId) throws UserDefinedException {

        logger.info("Entered getItinerary of PrintSericeImpl");
        PrintItinerary printItinerary = new PrintItinerary();
        TravelPackage travelPackage = travelPackageRespository.findByPackageId(packageId);
        if(travelPackage==null)
        {
            throw  new UserDefinedException("Travel Package not found");
        }
        String packageName=travelPackage.getPackageName();
        List<Destination> destinations = destinationRepository.findByTravelPackage(travelPackage);
        if(destinations.size()==0)
        {
            throw new UserDefinedException("NO Destination found");
        }
        printItinerary.setPackageName(packageName);
        // getting list of activities that with destination of the package
        List<DestinationActivity> destinationActivities = new ArrayList<>();
        for (Destination dest : destinations) {
            DestinationActivity destinationActivity = new DestinationActivity();
            String destName = dest.getDestinationName();
            List<ActivityDto> activityDtos = activitiesRepository.findByDestId(dest.getDestinationId()).stream().map(mapperActivity::mapActivityToActivityDto).collect(Collectors.toList());
            if(activityDtos.size()==0)
            {
                throw new UserDefinedException("NO Activites found with destinationID"+dest.getDestinationId());
            }
            destinationActivity.setDestinationName(destName);
            destinationActivity.setActivity(activityDtos);
            destinationActivities.add(destinationActivity);
        }
        printItinerary.setDestinationActivities(destinationActivities);

        return printItinerary;
    }

    // method to retrieve passenger details
    public PrintPassenger getPassengersDetail(long packageId) throws UserDefinedException {
        logger.info("Entered PrintController of PrintSericeImpl");
        PrintPassenger printPassenger=new PrintPassenger();
        TravelPackage travelPackage=travelPackageRespository.findByPackageId(packageId);
        if(travelPackage==null)
        {
            throw new UserDefinedException("No Travel package found with packageId "+packageId);
        }
        printPassenger.setPackageName(travelPackage.getPackageName());
        printPassenger.setCapacity(travelPackage.getPassengerCapacity());
        List<Passenger> passengers=passengerRepository.findByTravelPackage(travelPackage);
        if(passengers.size()==0)
        {
            throw new UserDefinedException("No Passenger under this tarvel package "+travelPackage);
        }
        printPassenger.setPassengersEnrolled(passengers.size());
        List<String> nameNumberList=new ArrayList<>();
        // creating list of passenger name + number
        for(Passenger passenger:passengers){
            nameNumberList.add(passenger.getPassengerName()+" : "+passenger.getPassengerNumber());
        }
        printPassenger.setNameNumber(nameNumberList);

        return printPassenger;

    }

    // method to get details of a single passenger
    public PrintPassengerInd getOnePassenger(long passId) throws UserDefinedException {
        logger.info("Entered getOnePassenger of PrintSericeImpl");
        PrintPassengerInd printPassengerInd=new PrintPassengerInd();
        Passenger passenger=passengerRepository.findByPassengerId(passId);
        if(passenger==null)
        {
            throw new UserDefinedException("Passenger not found");
        }
        printPassengerInd.setPassengerName(passenger.getPassengerName());
        printPassengerInd.setPassengerBalance(passenger.getBalance());
        printPassengerInd.setPassengerNumber(passenger.getPassengerNumber());
        List<PassengerActivity> passengerActivity=passActRepository.findByPassengerId(passId);
        if(passengerActivity.size()==0)
        {
            throw new UserDefinedException("No Activities with passengerId :"+passId);
        }
        List<String> activityDetails=new ArrayList<>();
        // list of activities + destination + price paid  for the passenger
        for(PassengerActivity passengerActivity1:passengerActivity)
        {
            activityDetails.add(passengerActivity1.getActivityName()+" : "+passengerActivity1.getDestination()+" : "+passengerActivity1.getPrice());
        }

        printPassengerInd.setActivityDetails(activityDetails);

        return printPassengerInd;

    }

    // method to get list of activities with slots avaialble
    public List<ActivityLeft> getAvailableActs() throws UserDefinedException {
        logger.info("Entered getAvailableActs of PrintSericeImpl");
        List<Activity> activity=activitiesRepository.findBySpaceLeft();
        if(activity.size()==0)
        {
            throw new UserDefinedException("No slots available at any Activity");
        }
        return activity.stream().map(mapperActivity :: mapActivityToActivityLeft).collect(Collectors.toList());


    }
}
