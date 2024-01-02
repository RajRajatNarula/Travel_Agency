package com.nymble.travelagency.Entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId; // package id
    @Column(unique = true)
    private String packageName; // name of the package
    private int passengerCapacity; // total passenger capacity of package
    private int passengerSlotLeft; // slots left for the package
}
