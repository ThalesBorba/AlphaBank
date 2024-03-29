package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.PaymentDomesticSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/payments/transfers")
public class PaymentsController {

    public static final String ID = "/{id}";
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/domestic")
    public ResponseEntity<PaymentSetupRequestDTO> createTransferIntent(@RequestBody PaymentSetupRequestDTO objDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID)
                .buildAndExpand(paymentService.createDomesticPaymentSetupRequest(objDto).getTransferRequestId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/international/submissions")
    public ResponseEntity<InternationalTransferSubmissionDTO> createInternationalTransferSub(@RequestBody InternationalTransferSubmissionDTO obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID)
                .buildAndExpand(paymentService.createInternationalTransferSub(obj).getTransferRequestId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/domestic/{transfer-request-id}")
    public ResponseEntity<PaymentSetupRequestDTO> returnTransferRequest(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(modelMapper.map(paymentService.getDomesticPaymentSetupRequest(id), PaymentSetupRequestDTO.class));
    }
    @GetMapping("/international/submissions/{transfer-submission-id}")
        public ResponseEntity<InternationalTransferSubmissionDTO> returnInternationalTransferSub(@PathVariable Long id) {
            return ResponseEntity.ok().body(modelMapper.map(paymentService.getInternationalTransferSub(id), InternationalTransferSubmissionDTO.class));
        }

      @PostMapping("/domestic/submissions")
      public ResponseEntity<PaymentDomesticSubmissionDTO> createTransferSubmission(@RequestBody PaymentDomesticSubmissionDTO obj){
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(ID)
                  .buildAndExpand(paymentService.createPaymentDomesticSubmission(obj).getTransferRequestId()).toUri();
          return ResponseEntity.created(uri).build();
      }

      @GetMapping("/domestic/submissions/{transfer-submission-id}")
      public ResponseEntity<PaymentDomesticSubmissionDTO> returnTransferSubmission(@PathVariable("transfer-submission-id") Long id){
        return ResponseEntity.ok().body(modelMapper.map(paymentService.getPaymentDomesticSubmission(id), PaymentDomesticSubmissionDTO.class));
      }

    @GetMapping("/history/{account-id}")
    public ResponseEntity<List<TransferInfo>> returnTransfersByAccount(@PathVariable String accountId){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.returnTransfersByAccount(accountId));
    }
    @GetMapping("/history")
    public ResponseEntity<List<TransferInfo>> returnTransfersByPeriod(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date fromDate, @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.returnPaymentsByTimePeriod(fromDate, toDate));
    }

    @GetMapping("/internacional/{transfer-request-id}")
    public ResponseEntity<TransferRequest> returnInternationalTransferRequest(@PathVariable String tranferRequestId){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.returnInternationalTransferRequest(tranferRequestId));
    }

    @DeleteMapping("/international/{transfer-request-id}")
    public ResponseEntity<InternationalTransferInitiation> deleteTransferRequest(@PathVariable Long
                                                                tranferRequestId){
        paymentService.deleteInternationalTransferRequest(tranferRequestId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/domestic/{transfer-request-id}")
    public ResponseEntity<DomesticTransferInitiation> deleteTransferDomesticRequest(@PathVariable Long
                                                                        tranferRequestId){
        paymentService.deleteDomesticTransferInitiation(tranferRequestId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
