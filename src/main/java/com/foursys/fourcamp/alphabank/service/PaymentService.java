package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.entities.TransferRequest;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.InternationalTransferSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import com.foursys.fourcamp.alphabank.repository.TransferRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private TransferInfoRepository transferInfoRepository;
    @Autowired
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    @Autowired
    private InternationalTransferSubmissionRepository internationalTransferSubmissionRepository;
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

    public List<TransferInfo> returnPaymentsByTimePeriod(Date fromDate, Date toDate) {
        return transferInfoRepository.findAll().stream().filter(transfer -> transfer.getDateSubmitted().after(fromDate)
        && transfer.getDateSubmitted().before(toDate)).toList();
    }

    public InternationalTransferSubmission createInternationalTransferSub(InternationalTransferSubmissionDTO obj) {
        return internationalTransferSubmissionRepository.save(modelMapper.map(obj, InternationalTransferSubmission.class));
    }

    public InternationalTransferSubmission getInternationalTransferSub(Long id) {
        Optional<InternationalTransferSubmission> obj = internationalTransferSubmissionRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public TransferRequest returnInternationalTransferRequest (String transferRequestId){
        return transferRequestRepository.findById(transferRequestId).orElseThrow(NoSuchElementException::new);
    }
}


