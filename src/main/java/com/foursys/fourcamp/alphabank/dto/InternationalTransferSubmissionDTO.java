package com.foursys.fourcamp.alphabank.dto;

import com.foursys.fourcamp.alphabank.entities.InternationalTransferInitiation;
import com.foursys.fourcamp.alphabank.entities.Risk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternationalTransferSubmissionDTO {


    private Long transferRequestId;

    private List<InternationalTransferInitiation> internationalTransferInitiation;

    private List<Risk> risks;
}
