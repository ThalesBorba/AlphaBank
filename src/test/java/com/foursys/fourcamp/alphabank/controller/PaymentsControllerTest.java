package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.PaymentSetupRequestDTO;
import com.foursys.fourcamp.alphabank.entities.PaymentSetupRequest;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
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

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
@SpringBootTest
class PaymentsControllerTest {

    public static final StatusEnum statusEnum = StatusEnum.PENDING;
    public static final Long ID = 1L;

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private PaymentsController paymentsController;
    @Mock
    private PaymentService paymentService;
    @Mock
    private ModelMapper modelMapper;

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
    void whenCreateThenReturnCreated() {
        when(paymentService.createDomesticPaymentSetupRequest(any())).thenReturn(paymentSetupRequest);

        ResponseEntity<PaymentSetupRequestDTO> response = paymentsController.createTransferIntent(paymentSetupRequestDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPaymentSetup();
    }


    private void startPaymentSetup() {
        paymentSetupRequest = new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        paymentSetupRequestDTO = new PaymentSetupRequestDTO(ID, statusEnum, new ArrayList<>(), new ArrayList<>());

        optional = Optional.of(new PaymentSetupRequest(ID, statusEnum, new ArrayList<>(), new ArrayList<>()));
    }
}