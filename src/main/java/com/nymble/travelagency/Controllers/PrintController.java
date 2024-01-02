package com.nymble.travelagency.Controllers;
import com.nymble.travelagency.Dto.ActivityLeft;
import com.nymble.travelagency.Dto.PrintItinerary;
import com.nymble.travelagency.Dto.PrintPassenger;
import com.nymble.travelagency.Dto.PrintPassengerInd;
import com.nymble.travelagency.Exception.UserDefinedException;
import com.nymble.travelagency.Service.PrintService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/print")
@AllArgsConstructor
public class PrintController {
    private static final Logger logger = LoggerFactory.getLogger(PrintController.class);

    private final PrintService printSerice;
   // controller to print itinerary of a particular package
    @GetMapping("package/{packageId}")
    public ResponseEntity<PrintItinerary> getItinerary(@PathVariable long packageId) throws UserDefinedException {
       logger.info("Entered getItinerary of PrintController");
        return new ResponseEntity<>(printSerice.getItinerary(packageId), HttpStatus.OK);
    }


    // controller to print passenger details of all passengers for a particular package
    @GetMapping("/passenger/{packageId}")
    public ResponseEntity<PrintPassenger> getPassengersDetail(@PathVariable long packageId) throws UserDefinedException {
        logger.info("Entered getPassenger of PrintController");
        return new ResponseEntity<>(printSerice.getPassengersDetail(packageId),HttpStatus.OK);
    }


    // controller to print details of a particular passengers with activities registered
    @GetMapping("/onepassenger/{passengerId}")
    public ResponseEntity<PrintPassengerInd> getOnePassengerDetail(@PathVariable long passengerId) throws UserDefinedException {
        logger.info("Entered getOnePassengerDetail of PrintController");
        return new ResponseEntity<>(printSerice.getOnePassenger(passengerId),HttpStatus.OK);
    }


    //controller to print details of actvities in which slots are left
    @GetMapping("/activityleft")
    public ResponseEntity<List<ActivityLeft>> getAvailableActivity() throws UserDefinedException {
        logger.info("Entered getAvailableActivity of PrintController");
        return new ResponseEntity<>(printSerice.getAvailableActs(),HttpStatus.OK);
    }
}
