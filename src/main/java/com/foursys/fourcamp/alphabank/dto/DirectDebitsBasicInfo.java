package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.DirectDebitBasicInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectDebitsBasicInfo implements Serializable {
    List<DirectDebitBasicInfo> directDebitBasicInfos;
}

