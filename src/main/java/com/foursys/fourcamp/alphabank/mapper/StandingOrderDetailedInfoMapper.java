package com.foursys.fourcamp.alphabank.mapper;

import com.foursys.fourcamp.alphabank.dtos.response.StandingOrderBasicInfo;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StandingOrderDetailedInfoMapper {

    StandingOrderDetailedInfoMapper INSTANCE = Mappers.getMapper(StandingOrderDetailedInfoMapper.class);

    StandingOrderBasicInfo toDTO(StandingOrderDetailedInfo standingOrderDetailedInfo);

}
