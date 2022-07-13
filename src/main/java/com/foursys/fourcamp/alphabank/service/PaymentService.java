package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    public List<TransferInfo> returnTransfersByPeriod(String accountId, Date fromDate, Date toDate) {
        if(returnTransfersByAccount(accountId).isEmpty()) {
            new NullPointerException("Código do cliente não encontrado");
        }
        return paymentRepository.findAllByAccountIdDate(accountId, fromDate, toDate);
    }

    public List<TransferInfo> returnTransfersByAccount (String accountId) {
        return paymentRepository.findAllByAccountId(accountId);
    }

}
