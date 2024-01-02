package com.nymble.travelagency.Mapper;

import com.nymble.travelagency.Dto.ActivityDto;
import com.nymble.travelagency.Dto.ActivityLeft;
import com.nymble.travelagency.Entities.Activity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapperActivity {
    MapperActivity instance= Mappers.getMapper(MapperActivity.class);

    //mapper to map activity to activityDto
    @Mapping(target = "destinationId",source =  "activity.destination.destinationId")
    ActivityDto mapActivityToActivityDto(Activity activity);


    // mapper to map activitydto to activity
    @Mapping(target = "activityName",source = "activity.activityName")
    @Mapping(target = "activityCost",source = "activity.activityCost")
    @Mapping(target = "destination",source = "activity.destination.destinationName")
    @Mapping(target = "spacesLeft",source = "activity.slotsLeft")

    ActivityLeft mapActivityToActivityLeft(Activity activity);
}
