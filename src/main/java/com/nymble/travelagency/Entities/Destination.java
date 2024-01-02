package com.nymble.travelagency.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Destination
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId; // destinatio  id
    @Column(unique = true)
    private String destinationName; // name of destination,cannot be null
    @ManyToOne
    @JoinColumn(name = "packageId")
    private TravelPackage travelPackage;  // travel package under which it comes
//    @OneToMany(mappedBy = "destination")
//    private List<Activity> activities;
}
