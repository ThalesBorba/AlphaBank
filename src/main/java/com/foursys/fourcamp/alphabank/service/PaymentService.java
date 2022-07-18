package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    private TransferInfoRepository transferInfoRepository;
    private ModelMapper modelMapper;

    public List<TransferInfo> returnTransfersByAccount(String accountId) {
        return transferInfoRepository.findAll().stream().filter(transfer -> transfer.getAccountId().equals(accountId))
                .toList();
    }

    public PaymentSetupRequest createDomesticPaymentSetupRequest(PaymentSetupRequestDTO obj) {
        getDomesticPaymentSetupRequest(obj.getTransferRequestId());

        return paymentSetupRequestRepository.save(modelMapper.map(obj, PaymentSetupRequest.class));
    }

    public PaymentSetupRequest getDomesticPaymentSetupRequest(Long Id) {
        Optional<PaymentSetupRequest> obj = paymentSetupRequestRepository.findById(Id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }



    public List<TransferInfo> returnPaymentsByTimePeriod(LocalDate fromDate, LocalDate toDate) {
        return transferInfoRepository.findAll().stream().filter(tranfer -> tranfer.getDateSubmitted().equals(Period
                .between(fromDate, toDate))).toList();
    }
}
