package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.*;
import com.foursys.fourcamp.alphabank.service.PaymentService;
import org.apache.coyote.Response;
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
import static org.mockito.Mockito.*;

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

    public static final String instructionIdentification = "bbbbb";

    public static final String endToEndIdentification = "aaaaa";

    public static final String debtorAccount = "cccc";

    public static final String debtorInformation = "dddd";

    public static final String blockFunds = "eeee";

    private static final BoPCodeEnum BO_P_CODE_ENUM = BoPCodeEnum.DEPOSITS;

    private static final String creditorAddress = "rrrr";

    private static final String debtorPhone = "tttt";

    private static final String countryIsoCode = "uuuu";
    private Optional<TransferRequest> optionalTransferRequest;
    private Optional<TransferInfo> optionalTransferInfo;

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    private static final TranferTypeEnum TRANFER_TYPE_ENUM = TranferTypeEnum.IRIS;
    private static final OurShareEnum OUR_SHARE_ENUM = OurShareEnum.OUR;

    @InjectMocks
    private PaymentsController paymentsController;
    @Mock
    private PaymentService paymentService;
    @Mock
    private ModelMapper modelMapper;

    private InternationalTransferInitiation internationalTransferInitiation;

    private DomesticTransferInitiation domesticTransferInitiation;

    private InternationalTransferSubmission internationalTransferSubmission;

    private InternationalTransferSubmissionDTO internationalTransferSubmissionDTO;

    private Optional<InternationalTransferSubmission> optionalInternational;

    private TransferInfo transferInfo;
    private TransferRequest transferRequest;
    private PaymentSetupRequest paymentSetupRequest;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;
    private Optional<PaymentSetupRequest> optional;


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
    void whenDeleteInternationalInitThenReturnSucess() {
        doNothing().when(paymentService).deleteInternationalTransferRequest(anyLong());
        ResponseEntity<InternationalTransferInitiation> response =paymentsController.deleteTransferRequest(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(paymentService,times(1)).deleteInternationalTransferRequest(anyLong());
    }

    @Test
    void whenDeleteDomesticInitThenReturnSucess() {
        doNothing().when(paymentService).deleteDomesticTransferInitiation(anyLong());
        ResponseEntity<DomesticTransferInitiation> response = paymentsController.deleteTransferDomesticRequest(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(paymentService, times(1)).deleteDomesticTransferInitiation(anyLong());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
        startInternationalTransferRequestSetup();
        startTransfersListByAccount();
        startInternationalInitiation();
        startDomesticInitiation();
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

    private void startInternationalInitiation() {
        internationalTransferInitiation = new InternationalTransferInitiation(ID, instructionIdentification, endToEndIdentification,
                new ArrayList<>(), debtorAccount, debtorInformation, blockFunds, BO_P_CODE_ENUM, creditorAddress,
                debtorPhone, countryIsoCode);

    }
    private void startDomesticInitiation() {
        domesticTransferInitiation = new DomesticTransferInitiation(ID, TRANFER_TYPE_ENUM, OUR_SHARE_ENUM, instructionIdentification,
                endToEndIdentification, new ArrayList<>(), debtorAccount, new ArrayList<>(), debtorInformation);
    }

}