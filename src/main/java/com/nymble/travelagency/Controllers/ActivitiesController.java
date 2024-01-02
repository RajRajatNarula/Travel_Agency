package com.nymble.travelagency.Controllers;
import com.nymble.travelagency.Dto.ActivityDto;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Service.ActivitiesService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@AllArgsConstructor
public class ActivitiesController {

    private static final Logger logger = LoggerFactory.getLogger(ActivitiesController.class);
    private final ActivitiesService activitiesService;

    //Controller to insert new Activity
    @PostMapping
    public ResponseEntity<ActivityDto> insertActivity(@RequestBody ActivityDto activityDto) throws UserDefinedException {
        logger.info("Entered insertActivity of ActivitiesController");
        return new ResponseEntity<>(activitiesService.insertActivity(activityDto), HttpStatus.CREATED);
    }


    // Controller to retrieve all activities
    @GetMapping
    public ResponseEntity<List<ActivityDto>> getAllActivity()
    {
        logger.info("Entered getAllActivity of ActivitiesController");
        return new ResponseEntity<>(activitiesService.getAllActivities(),HttpStatus.OK);
    }

}
