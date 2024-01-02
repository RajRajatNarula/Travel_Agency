package com.nymble.travelagency.Respository;

import com.nymble.travelagency.Entities.Destination;
import com.nymble.travelagency.Entities.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

    Destination findByDestinationId(long id);

    @Query(value = "Select destination_name from destination where destination_id=?",nativeQuery = true)
    String findByDestId(long id);

    List<Destination> findByTravelPackage(TravelPackage travelPackage);

    @Query(value = "Select destination_id from destination where package_id=?",nativeQuery = true)
    List<Long>  findByPackId(long id);
}
