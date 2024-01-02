package com.nymble.travelagency.Respository;

import com.nymble.travelagency.Entities.Passenger;
import com.nymble.travelagency.Entities.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long>
{
    @Query(value = "Select * from passenger where passenger_name = ? and package_id=?",nativeQuery = true)
    Passenger findBySameNameAndPackage(String name,long packag);

    List<Passenger> findByTravelPackage(TravelPackage travelPackage);
    Passenger findByPassengerId(long id);
}
