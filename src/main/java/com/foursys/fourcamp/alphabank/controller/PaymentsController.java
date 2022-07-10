package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PaymentsController {

    @Autowired
    private final PaymentService paymentService;

    @Autowired
    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
/*
    @PostMapping("/payments/transfers/domestic")
    public ResponseEntity<Object> createTransferIntent(@RequestBody @Valid class, @PathVariable String xIdempotencyKey,
            String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
            String xAbLang, String ocpApimSubscriptionKey){
    }

    @GetMapping("/payments/transfers/domestic/{transfer-request-id}")
    public ResponseEntity<Object> returnTransferRequest(@PathVariable String tranferRequestId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String authorization, String
            ocpApimSubscriptionKey){
    }

    @DeleteMapping("payments/transfers/domestic/{transfer-request-id}")
    public ResponseEntity<Object> deleteTransferRequest(@PathVariable String tranferRequestId, String xAbBankId, String
            xAbLang, String authorization, String ocpApimSubscriptionKey){
    }

    @PostMapping("/payments/transfers/domestic/submissions")
    public ResponseEntity<Object> createTransferSubmission(@RequestBody @Valid class, @PathVariable String xAbBankId,
            String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization, String
                                                                   ocpApimSubscriptionKey){
    }

    @GetMapping("/payments/transfers/domestic/submissions/{transfer-submission-id}")
    public ResponseEntity<Object> returnTransferSubmission(@PathVariable String tranferSubmissionId, String xAbBankId, String
            xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization, String
                                                         ocpApimSubscriptionKey){
    }

    @PostMapping("payments/transfers/internacional")
    public ResponseEntity<Object> createInternationalTransferIntent(@RequestBody @Valid class, @PathVariable String
           xIdempotencyKey, String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId,
           String authorization, String xAbLang, String ocpApimSubscriptionKey){
    }

    @GetMapping("payments/transfers/internacional/{transfer-request-id}")
    public ResponseEntity<Object> returnInternationalTransferRequest(@PathVariable String tranferRequestId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String xAbLang, String
            authorization, String ocpApimSubscriptionKey){
    }

    @DeleteMapping("payments/transfers/internacional/{transfer-request-id}")
    public ResponseEntity<Object> deleteInternationalTransferRequest(@PathVariable String tranferRequestId, String
            xAbBankId, String xAbLang, String authorization, String ocpApimSubscriptionKey){
    }

    @PostMapping("payments/transfers/internacional/submissions")
    public ResponseEntity<Object> createInternationalTransferSubmission(@RequestBody @Valid class, @PathVariable
    String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                                    String ocpApimSubscriptionKey){
    }

    @GetMapping("payments/transfers/internacional/submissions/{transfer-submission-id}")
    public ResponseEntity<Object> returnInternationalTransferSubmission(@PathVariable String tranferSubmissionId,
            String xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String
            authorization, String ocpApimSubscriptionKey){
    }

    @GetMapping("payments/transfers/history/{account-id}")
    public ResponseEntity<Object> returnTransfersByAccount(@PathVariable String accountId, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                                        String ocpApimSubscriptionKey){
    }

    @GetMapping("payments/transfers/history")
    public ResponseEntity<Object> returnTransfersByPeriod(@PathVariable String fromDate, String toDate, String
            xAbBankId, String xAbPsuLastLogged, String xAbPsuIp, String xAbInteractionId, String authorization,
                                                           String ocpApimSubscriptionKey){
    }
    */
}
