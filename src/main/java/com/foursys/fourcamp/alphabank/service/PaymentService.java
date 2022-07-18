package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    @Autowired
    private ModelMapper modelMapper;

//    public List<TransferInfo> returnTransfersByPeriod(String accountId, Date fromDate, Date toDate) {
//        if (returnTransfersByAccount(accountId).isEmpty()) {
//            throw new NullPointerException("Código do cliente não encontrado");
//        }
////        return paymentRepository.findAllByAccountIdDate(accountId, fromDate, toDate);
//    }
//
//    public List<TransferInfo> returnTransfersByAccount(String accountId) {
////        return paymentRepository.findAllByAccountId(accountId);
//    }

    public PaymentSetupRequest createDomesticPaymentSetupRequest(PaymentSetupRequestDTO obj) {
        return paymentSetupRequestRepository.save(modelMapper.map(obj, PaymentSetupRequest.class));
    }

    public PaymentSetupRequest getDomesticPaymentSetupRequest(Long Id) {
        Optional<PaymentSetupRequest> obj = paymentSetupRequestRepository.findById(Id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
