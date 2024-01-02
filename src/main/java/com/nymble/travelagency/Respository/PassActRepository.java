package com.nymble.travelagency.Respository;

import com.nymble.travelagency.Entities.PassengerActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassActRepository extends JpaRepository<PassengerActivity,Long> {

    List<PassengerActivity> findByPassengerId(long id);


}
