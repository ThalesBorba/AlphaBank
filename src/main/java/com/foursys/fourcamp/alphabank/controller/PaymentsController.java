package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments/transfers")
public class PaymentsController {

    @Autowired
    private final PaymentService paymentService;

    @Autowired
    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
/*
    @PostMapping("/domestic")
    public ResponseEntity<Object> createTransferIntent(@RequestBody @Valid class, @PathVariable String xIdempotencyKey,
            String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
            String xAbLang, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(method));
    }

    @GetMapping("/domestic/{transfer-request-id}")
    public ResponseEntity<Object> returnTransferRequest(@PathVariable String tranferRequestId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
            ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @DeleteMapping("/domestic/{transfer-request-id}")
    public ResponseEntity<Object> deleteTransferRequest(@PathVariable String tranferRequestId, String xAbBankId, String
            xAbLang, String authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.NO_CONTENT).body(method));
    }

    @PostMapping("/domestic/submissions")
    public ResponseEntity<Object> createTransferSubmission(@RequestBody @Valid class, @PathVariable String xAbBankId,
            String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization, String
                                                                   ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(method));
    }

    @GetMapping("/domestic/submissions/{transfer-submission-id}")
    public ResponseEntity<Object> returnTransferSubmission(@PathVariable String tranferSubmissionId, String xAbBankId,
    String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @PostMapping("/internacional")
    public ResponseEntity<Object> createInternationalTransferIntent(@RequestBody @Valid class, @PathVariable String
           xIdempotencyKey, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId,
           String authorization, String xAbLang, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(method));
    }

    @GetMapping("/internacional/{transfer-request-id}")
    public ResponseEntity<Object> returnInternationalTransferRequest(@PathVariable String tranferRequestId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @DeleteMapping("/internacional/{transfer-request-id}")
    public ResponseEntity<Object> deleteInternationalTransferRequest(@PathVariable String tranferRequestId, String
            xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.NO_CONTENT).body(method));
    }

    @PostMapping("/internacional/submissions")
    public ResponseEntity<Object> createInternationalTransferSubmission(@RequestBody @Valid class, @PathVariable
    String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                                    String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.CREATED).body(method));
    }

    @GetMapping("/internacional/submissions/{transfer-submission-id}")
    public ResponseEntity<Object> returnInternationalTransferSubmission(@PathVariable String tranferSubmissionId,
            String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String
            authorization, String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/history/{account-id}")
    public ResponseEntity<Object> returnTransfersByAccount(@PathVariable String accountId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                                        String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }

    @GetMapping("/history")
    public ResponseEntity<Object> returnTransfersByPeriod(@PathVariable String fromDate, String toDate, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                           String ocpApimSubscriptionKey){
        Handler.exceptionHandler(ResponseEntity.status(HttpStatus.OK).body(method));
    }
    */
}
