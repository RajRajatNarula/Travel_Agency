package com.nymble.travelagency.Respository;

import com.nymble.travelagency.Entities.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRespository extends JpaRepository<TravelPackage,Long> {

    TravelPackage findByPackageName(String name);
    TravelPackage findByPackageId(long id);

    String  findPackageNameByPackageId(long id);
}
