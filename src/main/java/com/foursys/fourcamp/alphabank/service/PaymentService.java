package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentDomesticSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentDomesticSubmission;
import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.Risk;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.entities.TransferRequest;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentDomesticSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.RiskRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import com.foursys.fourcamp.alphabank.repository.*;
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
    private PaymentDomesticSubmissionRepository paymentDomesticSubmissionRepository;

    @Autowired
    private RiskRepository riskRepository;

    private InternationalTransferSubmissionRepository internationalTransferSubmissionRepository;

    @Autowired
    private InternarionalTrasferInitiationRepository internarionalTrasferInitiationRepository;

    @Autowired
    private DomesticTransferInitiationRepository domesticTransferInitiationRepository;
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

    public TransferRequest returnInternationalTransferRequest(String transferRequestId) {
        return transferRequestRepository.findById(transferRequestId).orElseThrow(NoSuchElementException::new);
    }

    public void deleteInternationalTransferRequest(Long tranferRequestId) {
        internarionalTrasferInitiationRepository.findById(tranferRequestId).map(transferexist -> {
            internarionalTrasferInitiationRepository.deleteById(transferexist.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void deleteDomesticTransferInitiation(Long tranferRequestId) {
        domesticTransferInitiationRepository.findById(tranferRequestId).map(transferexist -> {
            domesticTransferInitiationRepository.deleteById(transferexist.getId());
            return Void.TYPE;
        }).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public PaymentDomesticSubmission createPaymentDomesticSubmission(PaymentDomesticSubmissionDTO obj) {
        return paymentDomesticSubmissionRepository.save(modelMapper.map(obj, PaymentDomesticSubmission.class));
    }

    public PaymentDomesticSubmission getPaymentDomesticSubmission(Long id) {
        Optional<PaymentDomesticSubmission> obj = paymentDomesticSubmissionRepository.findById(id);
        return obj.get();
    }
}


