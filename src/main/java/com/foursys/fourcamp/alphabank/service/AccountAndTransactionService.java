package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.StandingOrderDetailedDTO;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import com.foursys.fourcamp.alphabank.repository.StandingOrderDetailedInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class AccountAndTransactionService {

    private final StandingOrderDetailedInfoRepository standingOrderDetailedInfoRepository;

    public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                   authorization, String ocpApimSubscriptionKey) {
        StandingOrderDetailedInfo detailed = standingOrderDetailedInfoRepository.findByIdAndAccountId(Long.valueOf(standingOrderId), accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem permanente não encontrado!"));
        StandingOrderDetailedDTO detailedDTO = new StandingOrderDetailedDTO(detailed.getStandingOrderId(), detailed.getName()
                , detailed.getAccountId(), detailed.getAmount(), detailed.getCreditorAccount());
        return detailedDTO;
    }

}
