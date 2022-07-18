package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.InternationalTransferSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.InternationalTransferSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.InternationalTransferSubmissionRepository;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PaymentServiceTest {
    public static final StatusEnum statusEnum = StatusEnum.PENDING;
    public static final Long ID = 1L;

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private PaymentSetupRequestRepository paymentSetupRequestRepository;

    @Mock
    private InternationalTransferSubmissionRepository internationalTransferSubmissionRepository;

    @Mock
    private ModelMapper modelMapper;

    private PaymentSetupRequest paymentSetupRequest;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;

    private InternationalTransferSubmission internationalTransferSubmission;

    private InternationalTransferSubmissionDTO internationalTransferSubmissionDTO;

    private Optional<InternationalTransferSubmission> optionalInternational;
    private Optional<PaymentSetupRequest> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
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

}