package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentDomesticSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentDomesticSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentDomesticSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.InternationalTransferSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import com.foursys.fourcamp.alphabank.repository.TransferRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

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
class PaymentServiceTest {
    public static final StatusEnum STATUS_ENUM = StatusEnum.PENDING;
    private static final TransferScopeEnum TRANSFER_SCOPE_ENUM = TransferScopeEnum.INTERNATIONAL;
    private static final OurShareEnum OUR_SHARE_ENUM = OurShareEnum.OUR;
    public static final Long ID = 1L;
    public static final int INDEX = 0;
    public static final String STRING_ID = "1";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    public static final Date DATE = Date.valueOf("2022-07-19");

    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private PaymentSetupRequestRepository paymentSetupRequestRepository;

    @Mock
    private InternationalTransferSubmissionRepository internationalTransferSubmissionRepository;

    @Mock
    private TransferRequestRepository transferRequestRepository;
    @Mock
    private TransferInfoRepository transferInfoRepository;
    @Mock
    private ModelMapper modelMapper;
    private PaymentSetupRequest paymentSetupRequest;
    private TransferRequest transferRequest;
    private TransferInfo transferInfo;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;

    private InternationalTransferSubmission internationalTransferSubmission;

    private InternationalTransferSubmissionDTO internationalTransferSubmissionDTO;

    private Optional<InternationalTransferSubmission> optionalInternational;
    private Optional<PaymentSetupRequest> optional;
    private Optional<TransferRequest> optionalTransferRequest;
    private Optional<TransferInfo> optionalTransferInfo;

    @Mock
    private PaymentDomesticSubmissionRepository paymentDomesticSubmissionRepository;

    private PaymentDomesticSubmission paymentDomesticSubmission;

    private PaymentDomesticSubmissionDTO paymentDomesticSubmissionDTO;

    private Optional<PaymentDomesticSubmission> option;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
        startInternationalTransferRequestSetup();
        startTransfersListByAccount();
    }

    @Test
    void whenFindByIdThenReturnAnPaymentRequestInstance() {
        when(paymentSetupRequestRepository.findById(anyLong())).thenReturn(optional);

        PaymentSetupRequest response = paymentService.getDomesticPaymentSetupRequest(ID);

        assertNotNull(response);
        assertEquals(PaymentSetupRequest.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
        assertEquals(STATUS_ENUM, response.getStatusEnum());
    }

    @Test
    void whenFindByIdThenReturnInternationalSubmissionInstance() {
        when(internationalTransferSubmissionRepository.findById(anyLong())).thenReturn(optionalInternational);

        InternationalTransferSubmission response = paymentService.getInternationalTransferSub(ID);

        assertNotNull(response);
        assertEquals(InternationalTransferSubmission.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
    }

    @Test
    void whenFindByIdThenReturnAnTransferRequestInstance() {
        when(transferRequestRepository.findById(anyString())).thenReturn(optionalTransferRequest);

        TransferRequest response = paymentService.returnInternationalTransferRequest(STRING_ID);

        assertNotNull(response);
        assertEquals(TransferRequest.class, response.getClass());
        assertEquals(STRING_ID, response.getTranferRequestId());
        assertEquals(STATUS_ENUM, response.getStatus());
    }

    @Test
    void whenFindAllThenReturnAListOfTransfersByDate() {
        when(transferInfoRepository.findAll()).thenReturn(List.of(transferInfo));

        List<TransferInfo> response = paymentService.returnPaymentsByTimePeriod(Date.valueOf("2022-07-10"),
                Date.valueOf("2022-07-25"));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(DATE, response.get(INDEX).getDateSubmitted());
        assertEquals(TransferInfo.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
    }

    @Test
    void whenFindAllThenReturnAListOfTransfers() {
        when(transferInfoRepository.findAll()).thenReturn(List.of(transferInfo));

        List<TransferInfo> response = paymentService.returnTransfersByAccount(STRING_ID);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(TransferInfo.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(paymentSetupRequestRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));
        when(internationalTransferSubmissionRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try {
            paymentService.getDomesticPaymentSetupRequest(ID);
            paymentService.getInternationalTransferSub(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(paymentSetupRequestRepository.save(any())).thenReturn(paymentSetupRequest);

        PaymentSetupRequest response = paymentService.createDomesticPaymentSetupRequest(paymentSetupRequestDTO);

        assertNotNull(response);
        assertEquals(PaymentSetupRequest.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
        assertEquals(STATUS_ENUM, response.getStatusEnum());

    }

    @Test
    void whenCreateInternationalSubThenReturnSucess() {
        when(internationalTransferSubmissionRepository.save(any())).thenReturn(internationalTransferSubmission);
        InternationalTransferSubmission response = paymentService.createInternationalTransferSub(internationalTransferSubmissionDTO);
        assertNotNull(response);
        assertEquals(InternationalTransferSubmission.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());

    }

    private void startPaymentSetup() {
        paymentSetupRequest = new PaymentSetupRequest(ID, STATUS_ENUM, new ArrayList<>(), new ArrayList<>());
        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, STATUS_ENUM, new ArrayList<>(), new ArrayList<>());
        optional = Optional.of(new PaymentSetupRequest(ID, STATUS_ENUM, new ArrayList<>(), new ArrayList<>()));
        internationalTransferSubmission = new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>());
        internationalTransferSubmissionDTO = new InternationalTransferSubmissionDTO(ID, new ArrayList<>(), new ArrayList<>());
        optionalInternational = Optional.of(new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>()));
    }

    private void startInternationalTransferRequestSetup() {
        transferRequest = new TransferRequest(STRING_ID, STATUS_ENUM, LocalDate.now(), new InternationalTransferInitiation(),
                new Risk());
        optionalTransferRequest = Optional.of(new TransferRequest(STRING_ID, STATUS_ENUM, LocalDate.now(),
                new InternationalTransferInitiation(), new Risk()));
    }

    private void startTransfersListByAccount() {
        transferInfo = new TransferInfo(ID, "1", DATE, TRANSFER_SCOPE_ENUM, OUR_SHARE_ENUM, "A", "B", new Amount(),
                "C", new CreditorAccount(), "D", new RemittanceInformation());
        optionalTransferInfo = Optional.of(new TransferInfo(ID, "1", DATE, TRANSFER_SCOPE_ENUM, OUR_SHARE_ENUM, "A", "B", new Amount(),
                "C", new CreditorAccount(), "D", new RemittanceInformation()));

    }

    @BeforeEach
    void setUp2(){
        MockitoAnnotations.openMocks(this);
        startPaymentSubmission();
    }

    @Test
    public void whenFindByIdReturnPaymentSubmissionRequest(){
        when(paymentDomesticSubmissionRepository.findById(anyLong())).thenReturn(option);

        PaymentDomesticSubmission response = paymentService.getPaymentDomesticSubmission(ID);

        assertNotNull(response);
        assertEquals(PaymentDomesticSubmission.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
    }

    @Test
    public void whenFindByIdReturnObjectNotFound(){
        when(paymentDomesticSubmissionRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try {
            paymentService.getPaymentDomesticSubmission(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    private void startPaymentSubmission() {
        paymentDomesticSubmission = new PaymentDomesticSubmission(ID, new ArrayList<>(), new ArrayList<>());

        paymentDomesticSubmissionDTO = new PaymentDomesticSubmissionDTO(ID, new ArrayList<>(), new ArrayList<>());

        option = Optional.of(new PaymentDomesticSubmission(ID, new ArrayList<>(), new ArrayList<>()));
    }

}