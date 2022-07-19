package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferInitiation;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.TransferInfo;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.DomesticTranferInitiationRepository;
import com.foursys.fourcamp.alphabank.repository.InternarionalTrasferInitiationRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private TransferInfoRepository transferInfoRepository;
    @Autowired
    private PaymentSetupRequestRepository paymentSetupRequestRepository;

    private DomesticTranferInitiationRepository domesticTransferInitiationRepository;

    @Autowired
    private InternarionalTrasferInitiationRepository internarionalTrasferInitiationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<TransferInfo> returnTransfersByAccount(String accountId) {
        return transferInfoRepository.findAll().stream().filter(transfer -> transfer.getAccountId().equals(accountId))
                .toList();
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

    public void deleteInternationalTransferRequest(Long tranferRequestId) {
        internarionalTrasferInitiationRepository.findById(tranferRequestId).map(transferexist -> {
            internarionalTrasferInitiationRepository.deleteById(transferexist.getTranferRequestId());
            return Void.TYPE;
        }).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void deleteDomesticTransferInitiation(Long tranferRequestId) {
        domesticTransferInitiationRepository.findById(tranferRequestId).map(transferexist -> {
            domesticTransferInitiationRepository.deleteById(transferexist.getTranferRequestId());
            return Void.TYPE;
        }).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
