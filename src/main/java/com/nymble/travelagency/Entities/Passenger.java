package com.nymble.travelagency.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Entity
@Data
public class Passenger
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId; // passenger id
    @NotBlank
    private String passengerName; // name of passenger
    @NotBlank
    private String passengerNumber; // number of passenger
    private String membership; // type of membership that passenger has
    private double balance; // balance with passenger
    @ManyToOne
    @JoinColumn(name = "packageId",referencedColumnName = "packageId")
    private TravelPackage travelPackage; // travel package that passenger took


}
