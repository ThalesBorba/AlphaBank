package com.foursys.fourcamp.alphabank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.repository.PaymentSetupRequestRepository;

@SpringBootTest
class PaymentServiceTest {
    public static final StatusEnum statusEnum = StatusEnum.PENDING;
    public static final String domesticTransferInitiation = "valdir@mail.com";
    public static final Long ID = 1L;
    public static final String risk = "é, nois ta arriscado";

    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private PaymentSetupRequestRepository paymentSetupRequestRepository;
    @Mock
    private ModelMapper modelMapper;

    private PaymentSetupRequest paymentSetupRequest;
    private PaymentSetupRequestDTO paymentSetupRequestDTO;
    private Optional<PaymentSetupRequest> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(paymentSetupRequestRepository.save(any())).thenReturn(paymentSetupRequest);

        PaymentSetupRequest response = paymentService.createDomesticPaymentSetupRequest(paymentSetupRequestDTO);

        assertNotNull(response);
        assertEquals(PaymentSetupRequest.class, response.getClass());
        assertEquals(ID, response.getTransferRequestId());
        assertEquals(statusEnum, response.getStatusEnum());
        assertEquals(domesticTransferInitiation, response.getDomesticTransferInitiation());
        assertEquals(risk, response.getRisk());
    }

    private void startPaymentSetup() {
        paymentSetupRequest = new PaymentSetupRequest(ID, statusEnum, domesticTransferInitiation, risk);

        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, statusEnum, domesticTransferInitiation, risk);

        optional = Optional.of(new PaymentSetupRequest(ID, statusEnum, domesticTransferInitiation, risk));
    }
}