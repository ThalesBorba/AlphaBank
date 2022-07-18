package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.repository.BalancesResponseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountAndTransactionServiceTest {

    public static final Long ID = 1L;
    public static final int INDEX = 0;

    @InjectMocks
    private AccountAndTransactionService accountAndTransactionService;

    @Mock
    private BalancesResponseRepository balancesResponseRepository;

    @Mock
    private ModelMapper mapper;

    private BalancesResponseDTO balancesResponseDTO;

    private BalancesResponse balancesResponse;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
    }

    @Test
    void whenFinAllThenReturnAnListOfUsers() {
        when(balancesResponseRepository.findAll()).thenReturn(List.of(balancesResponse));

        List<BalancesResponse> response = accountAndTransactionService.findAllBalancesResponse();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(BalancesResponse.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());


    }

    private void startBalances() {
        balancesResponse = new BalancesResponse(ID, new ArrayList<>());
        balancesResponseDTO = new BalancesResponseDTO(ID, new ArrayList<>());

    }
}