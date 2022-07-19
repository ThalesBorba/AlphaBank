package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.OurShareEnum;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.enums.TransferScopeEnum;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.InternationalTransferSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import com.foursys.fourcamp.alphabank.repository.TransferInfoRepository;
import com.foursys.fourcamp.alphabank.repository.TransferRequestRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.hibernate.validator.internal.util.Contracts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PaymentServiceTest {
    public static final StatusEnum statusEnum = StatusEnum.PENDING;
    private static final TransferScopeEnum transferScopeEnum = TransferScopeEnum.INTERNATIONAL;
    private static final OurShareEnum ourShareEnum = OurShareEnum.OUR;
    public static final Long ID = 1L;
    public static final int INDEX = 0;
    public static final String STRING_ID = "1";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

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
        assertEquals(statusEnum, response.getStatusEnum());
    }

    @Test
    void whenFindByIdThenReturnInternationalSubmissionInstance() {
        when(internationalTransferSubmissionRepository.findById(anyLong())).thenReturn(optionalInternational);

        InternationalTransferSubmission response = paymentService.getInternationalTransferSub(ID);

        assertNotNull(response);
        assertEquals(InternationalTransferSubmission.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
    }

    void whenFindByIdThenReturnAnTransferRequestInstance() {
        when(transferRequestRepository.findById(anyString())).thenReturn(optionalTransferRequest);

        TransferRequest response = paymentService.returnInternationalTransferRequest(STRING_ID);

        assertNotNull(response);
        assertEquals(TransferRequest.class, response.getClass());
        assertEquals(STRING_ID, response.getTranferRequestId());
        assertEquals(statusEnum, response.getStatus());
    }

    @Test
    void whenFinAllThenReturnAListOfTransfers() {
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
        assertEquals(statusEnum, response.getStatusEnum());

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
        paymentSetupRequest = new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        optional = Optional.of(new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>()));

        internationalTransferSubmission = new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>());

        internationalTransferSubmissionDTO = new InternationalTransferSubmissionDTO(ID, new ArrayList<>(), new ArrayList<>());

        optionalInternational = Optional.of(new InternationalTransferSubmission(ID, new ArrayList<>(), new ArrayList<>()));

    }

    private void startInternationalTransferRequestSetup() {
        transferRequest = new TransferRequest(STRING_ID, statusEnum, LocalDate.now(), new InternationalTransferInitiation(),
                new Risk());
        optionalTransferRequest = Optional.of(new TransferRequest(STRING_ID, statusEnum, LocalDate.now(),
                new InternationalTransferInitiation(), new Risk()));
    }

    private void startTransfersListByAccount() {
        transferInfo = new TransferInfo(ID, "1", LocalDate.now(), transferScopeEnum, ourShareEnum, "A", "B", new Amount(),
                "C", new CreditorAccount(), "D", new RemittanceInformation());
        optionalTransferInfo = Optional.of(new TransferInfo(ID, "1", LocalDate.now(), transferScopeEnum, ourShareEnum, "A", "B", new Amount(),
                "C", new CreditorAccount(), "D", new RemittanceInformation()));

    }

}