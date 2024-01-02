package com.nymble.travelagency.Mapper;

import com.nymble.travelagency.Dto.PassengerDto;
import com.nymble.travelagency.Entities.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    // mapper to map passenger to passengerDto
    @Mapping(target = "travelPackageName",source = "passenger.travelPackage.packageName")
    @Mapping(target = "passengerNumber",source="passenger.passengerNumber")
    PassengerDto mapPassengerToPassengerDto(Passenger passenger);



}
