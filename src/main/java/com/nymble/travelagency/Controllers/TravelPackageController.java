package com.nymble.travelagency.Controllers;
import com.nymble.travelagency.Dto.TravelPackageDtoRequest;
import com.nymble.travelagency.Entities.TravelPackage;
import com.nymble.travelagency.Service.TravelPackageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@AllArgsConstructor
public class TravelPackageController {
    private static final Logger logger = LoggerFactory.getLogger(TravelPackageController.class);

    private final TravelPackageService travelPackageService;
    //controller to insert new package details
    @PostMapping
    public ResponseEntity<TravelPackageDtoRequest>  insertNewPackage(@RequestBody TravelPackageDtoRequest travelPackageDtoRequest)
    {
        logger.info("Entered insertNewPackage of TravelPackageController");
        return new ResponseEntity<>(travelPackageService.insertPackage(travelPackageDtoRequest), HttpStatus.CREATED);
    }

    // controller to retrieve all packages
    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllPackage()
    {
        logger.info("Entered getAllPackage of TravelPackageController");
        return new ResponseEntity<>(travelPackageService.getAllPackages(),HttpStatus.OK);
    }
}
