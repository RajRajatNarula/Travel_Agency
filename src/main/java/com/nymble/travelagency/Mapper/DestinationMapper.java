package com.nymble.travelagency.Mapper;

import com.nymble.travelagency.Dto.DestinationDto;
import com.nymble.travelagency.Entities.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    DestinationMapper INSTANCE = Mappers.getMapper(DestinationMapper.class);

    // mapper to map destination and destinatioDto
    DestinationDto mapDestinationToDestinationDto(Destination destination);

    // mapper to map destinationDto to destination
    Destination mapDestionationDtoToDestionation(DestinationDto destinationDto);
}
