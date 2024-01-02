package com.nymble.travelagency.Respository;

import com.nymble.travelagency.Entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activity,Long> {

    Activity findByActivityName(String name);

    @Query(value = "Select * from activity where slots_left>0",nativeQuery = true)
    List<Activity> findBySpaceLeft();

    @Query(value = "Select * from activity where destination_id=?",nativeQuery = true)
    List<Activity> findByDestId(long id);
}
