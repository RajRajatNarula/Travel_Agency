package com.nymble.travelagency.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PassengerActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passActId; // passenger activity Id
    private long passengerId; // id of passenger
    private String activityName; // name of activity that passenger enrolled for
    private double price; // price of the activity
    private String destination; // destination of activity

}
