package com.nymble.travelagency.Controllers;

import com.nymble.travelagency.Dto.ActivitiesSignUp;
import com.nymble.travelagency.Dto.PassengerDto;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Service.PassengerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@AllArgsConstructor
public class PassengerController {
    private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

    private final PassengerService passengerService;

    // controller to insert new passenger details
    @PostMapping
    public ResponseEntity<PassengerDto> insertNewPassenger(@RequestBody PassengerDto passengerDto) throws UserDefinedException {
        logger.info("Entered insertNewPassenger of PassengerController");
        return new ResponseEntity<>(passengerService.insertPassenger(passengerDto), HttpStatus.CREATED);
    }

    // controller to retrieve all passengers records
    @GetMapping
    public ResponseEntity<List<PassengerDto>> getAllPassenger()
    {
        logger.info("Entered getAllPassenger of PassengerController");
        return new ResponseEntity<>(passengerService.getAllPassenger(),HttpStatus.OK);
    }


    // controller to sign up a passenger for activities
    @PostMapping("/activitysignup")
    public ResponseEntity<ActivitiesSignUp> passActSignUp(@RequestBody ActivitiesSignUp activitiesSignUp) throws UserDefinedException {
        logger.info("Entered passActSignUp");
        return  new ResponseEntity<>(passengerService.signUp(activitiesSignUp),HttpStatus.OK);
    }
}
