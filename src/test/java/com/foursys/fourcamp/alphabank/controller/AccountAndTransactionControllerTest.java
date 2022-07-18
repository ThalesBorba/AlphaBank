package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.service.AccountAndTransactionService;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountAndTransactionControllerTest {

    public static final Long ID = 1L;
    public static final int INDEX = 0;
    private BalancesResponse balancesResponse = new BalancesResponse();
    private BalancesResponseDTO balancesResponseDTO = new BalancesResponseDTO();

    @InjectMocks
    private AccountAndTransactionController accountAndTransactionController;

    @Mock
    private ModelMapper mapper;

    @Mock
    private AccountAndTransactionService accountAndTransactionService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
    }

    @Test
    void whenFindAllThenReturnLitOfUserDTO() {
        when(accountAndTransactionService.findAllBalancesResponse()).thenReturn(List.of(balancesResponse));
        when(mapper.map(any(), any())).thenReturn(balancesResponseDTO);

        ResponseEntity<List<BalancesResponseDTO>> response = accountAndTransactionController.findAllBalancesResponse();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(BalancesResponseDTO.class, response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());

    }

    private void startBalances() {
        balancesResponse = new BalancesResponse(ID, new ArrayList<>());
        balancesResponseDTO = new BalancesResponseDTO(ID, new ArrayList<>());
    }
}