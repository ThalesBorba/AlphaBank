package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    
    public List<TransferInfo> returnTransfersByPeriod(String accountId, Date fromDate, Date toDate) {
        if(returnTransfersByAccount(accountId).isEmpty()) {
            throw new NullPointerException("Código do cliente não encontrado");
        }
        return paymentRepository.findAllByAccountIdDate(accountId, fromDate, toDate);
    }

    public List<TransferInfo> returnTransfersByAccount (String accountId) {
        return paymentRepository.findAllByAccountId(accountId);
    }
}
