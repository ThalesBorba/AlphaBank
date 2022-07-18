package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    private ModelMapper modelMapper;

    public List<TransferInfo> returnTransfersByPeriod(String accountId, Date fromDate, Date toDate) {
        if (returnTransfersByAccount(accountId).isEmpty()) {
            throw new NullPointerException("Código do cliente não encontrado");
        }
        return paymentRepository.findAllByAccountIdDate(accountId, fromDate, toDate);
    }

    public List<TransferInfo> returnTransfersByAccount(String accountId) {
        return paymentRepository.findAllByAccountId(accountId);
    }

    public PaymentSetupRequest createDomesticPaymentSetupRequest(PaymentSetupRequestDTO obj) {
        return paymentSetupRequestRepository.save(modelMapper.map(obj, PaymentSetupRequest.class));
    }

    public PaymentSetupRequest getDomesticPaymentSetupRequest(Long Id) {
        Optional<PaymentSetupRequest> obj = paymentSetupRequestRepository.findById(Id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
