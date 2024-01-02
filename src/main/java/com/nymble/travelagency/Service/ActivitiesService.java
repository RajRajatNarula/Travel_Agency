package com.nymble.travelagency.Service;

import com.nymble.travelagency.Dto.ActivityDto;
import com.nymble.travelagency.Exception.UserDefinedException;

import java.util.List;

public interface ActivitiesService {
    ActivityDto insertActivity(ActivityDto activityDto) throws UserDefinedException;
    List<ActivityDto> getAllActivities();
}
