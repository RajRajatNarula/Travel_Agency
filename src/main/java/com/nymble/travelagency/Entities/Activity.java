package com.nymble.travelagency.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long activityId; // acitvity Id
    @Column(unique = true)
    private String activityName; // name of activity
    private String description; // description about the activity
    private double activityCost; // cost of the activity
    private int capacity; // total slots for the acitvity
    private int slotsLeft; // slots left for the activity

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinationId",referencedColumnName = "destinationId")
    private Destination destination; // destination where activity is
}
