package com.foursys.fourcamp.alphabank.mapper;

import com.foursys.fourcamp.alphabank.entities.DirectDebitBasicInfo;
import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DirectDebitDetailedInfoMapper {

    DirectDebitDetailedInfoMapper INSTANCE = Mappers.getMapper(DirectDebitDetailedInfoMapper.class);

    default DirectDebitBasicInfo toDTO(DirectDebitDetailedInfo d) {
        return new DirectDebitBasicInfo(d.getAccountId(), d.getProductName(), d.getDirectDebitId(), d.getStatus());
    }

}
