package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentDomesticSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class PaymentsControllerTest {

    public static final StatusEnum statusEnum = StatusEnum.PENDING;
    public static final Long ID = 1L;
    public static final String STRING_ID = "1";
    public static final int INDEX = 0;
    public static final Date DATE = Date.valueOf("2022-07-19");
    private static final TransferScopeEnum transferScopeEnum = TransferScopeEnum.INTERNATIONAL;
    private static final OurShareEnum ourShareEnum = OurShareEnum.OUR;
    private static final LocalDate localDate = LocalDate.now();
    private static final Risk risk = new Risk();
    private static final Amount amount = new Amount();
    private static final CreditorAccount creditorAccount = new CreditorAccount();
    private static final RemittanceInformation remittanceInformation = new RemittanceInformation();
    private static final InternationalTransferInitiation transferInitiation = new InternationalTransferInitiation();
    private Optional<TransferRequest> optionalTransferRequest;
    private Optional<TransferInfo> optionalTransferInfo;

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private PaymentsController paymentsController;
    @Mock
    private PaymentService paymentService;
    @Mock
    private ModelMapper modelMapper;

    private InternationalTransferSubmission internationalTransferSubmission;

    private InternationalTransferSubmissionDTO internationalTransferSubmissionDTO;

    private Optional<InternationalTransferSubmission> optionalInternational;

    private TransferInfo transferInfo;
    private TransferRequest transferRequest;
    private PaymentSetupRequest paymentSetupRequest;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;
    private Optional<PaymentSetupRequest> optional;

    private PaymentDomesticSubmission paymentDomesticSubmission;

    private PaymentDomesticSubmissionDTO paymentDomesticSubmissionDTO;

    private Optional<PaymentDomesticSubmission> option;

    @Test
    void whenFindByIdThenReturnSucess() {
        when(paymentService.getDomesticPaymentSetupRequest(anyLong())).thenReturn(paymentSetupRequest);
        when(modelMapper.map(any(), any())).thenReturn(paymentSetupRequestDTO);

        ResponseEntity<PaymentSetupRequestDTO> response = paymentsController.returnTransferRequest(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PaymentSetupRequestDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getTransferRequestId());
        assertEquals(statusEnum, response.getBody().getStatusEnum());
    }

    @Test
    void whenFindByIdThenReturnInternationalSubSucess() {
        when(paymentService.getInternationalTransferSub(anyLong())).thenReturn(internationalTransferSubmission);
        when(modelMapper.map(any(), any())).thenReturn(internationalTransferSubmissionDTO);

        ResponseEntity<InternationalTransferSubmissionDTO> response = paymentsController.returnInternationalTransferSub(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(InternationalTransferSubmissionDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getTransferRequestId());
    }

    @Test
    void whenFindAllThenReturnListOfTransactionsByAccount() {
        when(paymentService.returnTransfersByAccount(STRING_ID)).thenReturn(List.of(transferInfo));

        ResponseEntity<List<TransferInfo>> response = paymentsController.returnTransfersByAccount(STRING_ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(TransferInfo.class, response.getBody().get(INDEX).getClass());

        assertEquals(STRING_ID, response.getBody().get(INDEX).getAccountId());
    }

    @Test
    void whenFindAllThenReturnListOfTransactionsByDate() {
        when(paymentService.returnPaymentsByTimePeriod(Date.valueOf("2022-07-10"), Date.valueOf("2022-07-25")))
                .thenReturn(List.of(transferInfo));

        ResponseEntity<List<TransferInfo>> response = paymentsController.returnTransfersByPeriod(
                Date.valueOf("2022-07-10"), Date.valueOf("2022-07-25"));

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(TransferInfo.class, response.getBody().get(INDEX).getClass());
        assertEquals(DATE, response.getBody().get(INDEX).getDateSubmitted());
    }

    @Test
    void whenFindTransferByAccountIdThenReturnSucess() {
        when(paymentService.returnInternationalTransferRequest(anyString())).thenReturn(transferRequest);

        ResponseEntity<TransferRequest> response = paymentsController.returnInternationalTransferRequest(STRING_ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());

        assertEquals(STRING_ID, response.getBody().getTranferRequestId());
        assertEquals(statusEnum, response.getBody().getStatus());
        assertEquals(localDate, response.getBody().getCreationTimeStamp());
        assertEquals(transferInitiation, response.getBody().getTransferInitiation());
        assertEquals(risk, response.getBody().getRisk());

    }

    @Test
    void whenCreateThenReturnCreated() {
        when(paymentService.createDomesticPaymentSetupRequest(any())).thenReturn(paymentSetupRequest);

        ResponseEntity<PaymentSetupRequestDTO> response = paymentsController.createTransferIntent(paymentSetupRequestDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void whenCreateInternationalSubThenReturnCreated() {
        when(paymentService.createInternationalTransferSub(any())).thenReturn(internationalTransferSubmission);

        ResponseEntity<InternationalTransferSubmissionDTO> response = paymentsController.createInternationalTransferSub(internationalTransferSubmissionDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));

    }

    @Test
    void whenCreatePaymentSubmissionThenReturnCreate(){
        when(paymentService.createPaymentDomesticSubmission(any())).thenReturn(paymentDomesticSubmission);

        ResponseEntity<PaymentDomesticSubmissionDTO> response = paymentsController.createTransferSubmission(paymentDomesticSubmissionDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }
    @Test
    void whenFindByIdPaymentSubmissionReturnSucess(){
        when(paymentService.getPaymentDomesticSubmission(anyLong())).thenReturn(paymentDomesticSubmission);
        when(modelMapper.map(any(), any())).thenReturn(paymentDomesticSubmissionDTO);

        ResponseEntity<PaymentDomesticSubmissionDTO> response = paymentsController.returnTransferSubmission(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PaymentDomesticSubmissionDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getTransferRequestId());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
        startInternationalTransferRequestSetup();
        startTransfersListByAccount();
        startPaymentDomesticSubmissionSetup();
    }


    private void startPaymentSetup() {
        paymentSetupRequest = new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>());
        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, statusEnum, new ArrayList<>(), new ArrayList<>());
        optional = Optional.of(new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>()));
        internationalTransferSubmission = new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>());
        internationalTransferSubmissionDTO = new InternationalTransferSubmissionDTO(ID, new ArrayList<>(), new ArrayList<>());
        optionalInternational = Optional.of(new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>()));
    }

    private void startInternationalTransferRequestSetup() {
        transferRequest = new TransferRequest(STRING_ID, statusEnum, LocalDate.now(), transferInitiation,
                risk);
        optionalTransferRequest = Optional.of(new TransferRequest(STRING_ID, statusEnum, LocalDate.now(),
                transferInitiation, risk));
    }

    private void startTransfersListByAccount() {
        transferInfo = new TransferInfo(ID, "1", DATE, transferScopeEnum, ourShareEnum, "A", "B", amount,
                "C", creditorAccount, "D", remittanceInformation);
        optionalTransferInfo = Optional.of(new TransferInfo(ID, "1", DATE, transferScopeEnum, ourShareEnum, "A", "B", amount,
                "C", creditorAccount, "D", remittanceInformation));

    }

    private void startPaymentDomesticSubmissionSetup(){
        paymentDomesticSubmission = new PaymentDomesticSubmission(ID, new ArrayList<>(), new ArrayList<>());
        paymentDomesticSubmissionDTO = new PaymentDomesticSubmissionDTO(ID, new ArrayList<>(), new ArrayList<>());
        option = Optional.of(new PaymentDomesticSubmission(ID, new ArrayList<>(), new ArrayList<>()));
    }

}