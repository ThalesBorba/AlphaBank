package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.StandingOrderDetailedDTO;
import com.foursys.fourcamp.alphabank.entities.DirectDebitDetailedInfo;
import com.foursys.fourcamp.alphabank.entities.StandingOrderDetailedInfo;
import com.foursys.fourcamp.alphabank.repository.DirectDebitDetailedInfoRepository;
import com.foursys.fourcamp.alphabank.repository.StandingOrderDetailedInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AccountAndTransactionService {

    private final StandingOrderDetailedInfoRepository standingOrderDetailedInfoRepository;

    private final DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;

    public StandingOrderDetailedDTO findByIdOrderDetailed(String accountId, String standingOrderId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                   authorization, String ocpApimSubscriptionKey) {
        StandingOrderDetailedInfo detailed = standingOrderDetailedInfoRepository.findByIdAndAccountId(standingOrderId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem permanente não encontrado!"));
        StandingOrderDetailedDTO detailedDTO = new StandingOrderDetailedDTO(detailed.getStandingOrderId(), detailed.getName()
                , detailed.getAccountId(), detailed.getAmount(), detailed.getCreditorAccount());
        return detailedDTO;
    }

    public DirectDebitDetailedInfo findByIdDirectDebitsDetailed(String accountId, String directDebitId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbLang, String xAbInteractionId, String
                                                                        authorization, String ocpApimSubscriptionKey) {
        DirectDebitDetailedInfo detailed = directDebitDetailedInfoRepository.findByIdAndAccountId(directDebitId, accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Débito direto não encontrado!"));
        return detailed;
    }

}
