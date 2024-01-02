package com.nymble.travelagency.Service.impl;

import com.nymble.travelagency.Dto.ActivityDto;
import com.nymble.travelagency.Entities.Activity;
import com.nymble.travelagency.Entities.Destination;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Mapper.MapperActivity;
import com.nymble.travelagency.Respository.ActivitiesRepository;
import com.nymble.travelagency.Respository.DestinationRepository;
import com.nymble.travelagency.Service.ActivitiesService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActivitiesServiceImpl implements ActivitiesService {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiesServiceImpl.class);


    private final ActivitiesRepository activitiesRepository;
    private final DestinationRepository destinationRepository;
    private  final MapperActivity mapperActivity;
    // method to insert new activity
    public ActivityDto insertActivity(ActivityDto activityDto) throws UserDefinedException {

        logger.info("Entered insertActivity of ActivitiesServiceImpl");
        Activity activity=new Activity();
        // setting values from activityDto to activity to save in db
        activity.setActivityCost(activityDto.getActivityCost());
        activity.setActivityName(activityDto.getActivityName());
        activity.setCapacity(activityDto.getCapacity());
        activity.setDescription(activityDto.getDescription());
        // retrieving destination based on destination id
        Destination destination=destinationRepository.findByDestinationId(activityDto.getDestinationId());
        if(destination==null)
        {
            throw  new UserDefinedException("Destination  is NULL");
        }
        activity.setDestination(destination);

        activitiesRepository.save(activity);
        return activityDto;
    }

    // method to retrieve all activities
    public List<ActivityDto> getAllActivities() {
        logger.info("Entered getAllActivities of getAllActivities");
        return activitiesRepository.findAll().stream().map(mapperActivity :: mapActivityToActivityDto).collect(Collectors.toList());
    }
}
