package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.entities.Card;
import com.foursys.fourcamp.alphabank.repository.BalancesResponseRepository;
import com.foursys.fourcamp.alphabank.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountAndTransactionServiceTest {

    public static final Long ID = 1L;
    public static final String STRING_ID = "1";
    public static final int INDEX = 0;

    public static final Date DATE = Date.valueOf("2022-07-19");

    @InjectMocks
    private AccountAndTransactionService accountAndTransactionService;

    @Mock
    private BalancesResponseRepository balancesResponseRepository;

    @Mock
    private CardRepository cardRepository;

    @Mock
    private ModelMapper mapper;

    private BalancesResponseDTO balancesResponseDTO;

    private BalancesResponse balancesResponse;

    private Card card;

    private Optional<Card> cardOptional;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
        startCard();
    }

    @Test
    void whenFinAllThenReturnAnListOfUsers() {
        when(balancesResponseRepository.findAll()).thenReturn(new ArrayList<>(List.of(balancesResponse)));

        List<BalancesResponse> response = accountAndTransactionService.findAllBalancesResponse();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(BalancesResponse.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(ID, response.get(INDEX).getId());


    }

    @Test
    void whenFindAccountThenReturnAListOfCards() {
        when(cardRepository.findAll()).thenReturn(List.of(card));

        ArrayList<Card> response = new ArrayList<>(accountAndTransactionService.returnAllCardsByAccount(STRING_ID));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Card.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(STRING_ID, response.get(INDEX).getAccountId());


    }

    private void startBalances() {
        balancesResponse = new BalancesResponse(ID, new ArrayList<>());
        balancesResponseDTO = new BalancesResponseDTO(ID, new ArrayList<>());

    }

    private void startCard() {
        card = new Card(ID, "4567456745674567", "Jose", "1234", DATE, "VISA", 123, false, "1");
        cardOptional = Optional.of(new Card(ID, "4567456745674567", "Jose", "1234", DATE, "VISA", 123, false, "1"));
    }
}