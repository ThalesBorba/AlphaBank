package com.foursys.fourcamp.alphabank.mapper;

import com.foursys.fourcamp.alphabank.dto.StandingOrderBasicInfo;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StandingOrderDetailedInfoMapper {

    StandingOrderDetailedInfoMapper INSTANCE = Mappers.getMapper(StandingOrderDetailedInfoMapper.class);

    default StandingOrderBasicInfo toDTO(StandingOrderDetailedInfo s) {
        return new StandingOrderBasicInfo(s.getStandingOrderId(), s.getName(),
                s.getAccountId(), s.getAmount(), s.getCreditorAccount());
    }

}
