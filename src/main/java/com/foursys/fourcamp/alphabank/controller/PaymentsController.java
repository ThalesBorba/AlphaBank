package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.exceptions.Handler;
import com.foursys.fourcamp.alphabank.service.PaymentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/payments/transfers")
public class PaymentsController {

    private final PaymentService paymentService;
    private ModelMapper modelMapper;

    @PostMapping("/domestic")
    public ResponseEntity<PaymentSetupRequestDTO> createTransferIntent(@RequestBody PaymentSetupRequestDTO objDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(paymentService.createDomesticPaymentSetupRequest(objDto).getTransferRequestId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/domestic/{transfer-request-id}")
    public ResponseEntity<PaymentSetupRequestDTO> returnTransferRequest(@PathVariable Long Id) {
        return ResponseEntity.ok()
                .body(modelMapper.map(paymentService.getDomesticPaymentSetupRequest(Id), PaymentSetupRequestDTO.class));
    }

    /*
     * 
     * @GetMapping("/domestic/{transfer-request-id}")
     * public ResponseEntity<Object> returnTransferRequest(@PathVariable String
     * tranferRequestId, String xAbBankId, String
     * xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang,
     * String authorization, String
     * ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
     * }
     * 
     * @DeleteMapping("/domestic/{transfer-request-id}")
     * public ResponseEntity<Object> deleteTransferRequest(@PathVariable String
     * tranferRequestId, String xAbBankId, String
     * xAbLang, String authorization, String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.NO_CONTENT).body(
     * method));
     * }
     * 
     * @PostMapping("/domestic/submissions")
     * public ResponseEntity<Object> createTransferSubmission(@RequestBody @Valid
     * class, @PathVariable String xAbBankId,
     * String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String
     * authorization, String
     * ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(
     * method));
     * }
     * 
     * @GetMapping("/domestic/submissions/{transfer-submission-id}")
     * public ResponseEntity<Object> returnTransferSubmission(@PathVariable String
     * tranferSubmissionId, String xAbBankId,
     * String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String
     * authorization, String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
     * }
     * 
     * @PostMapping("/internacional")
     * public ResponseEntity<Object>
     * createInternationalTransferIntent(@RequestBody @Valid class, @PathVariable
     * String
     * xIdempotencyKey, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp,
     * String xAbInteractionId,
     * String authorization, String xAbLang, String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(
     * method));
     * }
     * 
     * @GetMapping("/internacional/{transfer-request-id}")
     * public ResponseEntity<Object>
     * returnInternationalTransferRequest(@PathVariable String tranferRequestId,
     * String
     * xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId,
     * String xAbLang, String
     * authorization, String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
     * }
     * 
     * @DeleteMapping("/internacional/{transfer-request-id}")
     * public ResponseEntity<Object>
     * deleteInternationalTransferRequest(@PathVariable String tranferRequestId,
     * String
     * xAbBankId, String xAbLang, String authorization, String
     * ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.NO_CONTENT).body(
     * method));
     * }
     * 
     * @PostMapping("/internacional/submissions")
     * public ResponseEntity<Object>
     * createInternationalTransferSubmission(@RequestBody @Valid
     * class, @PathVariable
     * String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String
     * xAbInteractionId, String authorization,
     * String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(
     * method));
     * }
     * 
     * @GetMapping("/internacional/submissions/{transfer-submission-id}")
     * public ResponseEntity<Object>
     * returnInternationalTransferSubmission(@PathVariable String
     * tranferSubmissionId,
     * String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String
     * xAbInteractionId, String
     * authorization, String ocpApimSubscriptionKey){
     * Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
     * }
     */
     @GetMapping("/history/{account-id}")
     public ResponseEntity<Object> returnTransfersByAccount(@PathVariable String accountId){
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(paymentService.
                returnTransfersByAccount(accountId)));
     }

    @GetMapping("/history")
    public ResponseEntity<Object> returnTransfersByPeriod(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate fromDate, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
        return Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK)
                .body(paymentService.returnPaymentsByTimePeriod(fromDate, toDate)));
    }

}
