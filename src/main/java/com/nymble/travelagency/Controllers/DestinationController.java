package com.nymble.travelagency.Controllers;
import com.nymble.travelagency.Dto.DestinationDto;
import com.nymble.travelagency.Entities.Destination;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Service.DestinationService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
@AllArgsConstructor
public class DestinationController {
    private static final Logger logger = LoggerFactory.getLogger(DestinationController.class);

    private final DestinationService destinationService;
   // Controller to insert new destination in a package
    @PostMapping
    public ResponseEntity<DestinationDto> insertDestination(@RequestBody DestinationDto destination) throws UserDefinedException {
        logger.info("Entered insertDestination of DestinationController");
        return new ResponseEntity<>(destinationService.insertDestination(destination), HttpStatus.CREATED);
    }

    // controller to retrieve all destinations
    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestination(){
        logger.info("Entered getAllDestination of DestinationController");
        return new ResponseEntity<>(destinationService.getAllDestination(),HttpStatus.OK);
    }
}
