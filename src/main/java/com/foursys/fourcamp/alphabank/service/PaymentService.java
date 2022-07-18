package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.entities.TransferRequest;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private TransferInfoRepository transferInfoRepository;
    @Autowired
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    @Autowired
    private TransferRequestRepository transferRequestRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TransferInfo> returnTransfersByAccount(String accountId) {
        return transferInfoRepository.findAll().stream().filter(transfer -> transfer.getAccountId().equals(accountId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PaymentSetupRequest createDomesticPaymentSetupRequest(PaymentSetupRequestDTO obj) {
        return paymentSetupRequestRepository.save(modelMapper.map(obj, PaymentSetupRequest.class));
    }

    public PaymentSetupRequest getDomesticPaymentSetupRequest(Long Id) {
        Optional<PaymentSetupRequest> obj = paymentSetupRequestRepository.findById(Id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<TransferInfo> returnPaymentsByTimePeriod(LocalDate fromDate, LocalDate toDate) {
        return transferInfoRepository.findAll().stream().filter(tranfer -> tranfer.getDateSubmitted().equals(Period
                .between(fromDate, toDate))).toList();
    }

    public TransferRequest returnInternationalTransferRequest(String transferRequestId) {
        return transferRequestRepository.findById(transferRequestId).orElseThrow(NoSuchElementException::new);
    }
}
