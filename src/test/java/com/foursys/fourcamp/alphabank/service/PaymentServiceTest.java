package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.PaymentDomesticSubmissionDTO;
import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentDomesticSubmission;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.PaymentDomesticSubmissionRepository;
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
    private ModelMapper modelMapper;
    private PaymentSetupRequest paymentSetupRequest;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;
    private Optional<PaymentSetupRequest> optional;

    @Mock
    private PaymentDomesticSubmissionRepository paymentDomesticSubmissionRepository;

    private PaymentDomesticSubmission paymentDomesticSubmission;

    private PaymentDomesticSubmissionDTO paymentDomesticSubmissionDTO;

    private Optional<PaymentDomesticSubmission> option;

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
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(paymentSetupRequestRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try {
            paymentService.getDomesticPaymentSetupRequest(ID);
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

    private void startPaymentSetup() {
        paymentSetupRequest = new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        optional = Optional.of(new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>()));
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