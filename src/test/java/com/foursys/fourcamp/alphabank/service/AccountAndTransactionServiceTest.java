package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
import com.foursys.fourcamp.alphabank.enums.StatusEnum;
import com.foursys.fourcamp.alphabank.mapper.DirectDebitDetailedInfoMapper;
import com.foursys.fourcamp.alphabank.repository.BalancesResponseRepository;
import com.foursys.fourcamp.alphabank.repository.CardRepository;
import com.foursys.fourcamp.alphabank.repository.DirectDebitDetailedInfoRepository;
import com.foursys.fourcamp.alphabank.repository.TransactionsRepository;
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
    private TransactionsRepository transactionsRepository;

    @Mock
    private DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;

    @Mock
    private ModelMapper mapper;

    public static final StatusEnum STATUS_ENUM = StatusEnum.PENDING;

    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM = ProductIdentifierEnum.ACCOUNT;

    public static final CreditDebitIndicatorEnum CREDIT_DEBIT_INDICATOR_ENUM = CreditDebitIndicatorEnum.CREDIT;

    public static final Amount AMOUNT = new Amount();

    public static final MerchantDetails MERCHANT_DETAILS = new MerchantDetails();

    private BalancesResponseDTO balancesResponseDTO;

    private BalancesResponse balancesResponse;

    private DirectDebitDetailedInfo directDebitDetailedInfo;

    private DirectDebitDetailedInfoMapper directDebitDetailedInfoMapper;

    private Card card;

    private Transaction transaction;

    private Optional<DirectDebitDetailedInfo> optionalDirectDebitDetailedInfo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
        startCard();
        startTransaction();
        startDirectDebit();
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

    @Test
    void whenFindAccountThenReturnAListOfTransactions() {
        when(transactionsRepository.findAll()).thenReturn(List.of(transaction));

        ArrayList<Transaction> response = new ArrayList<>(accountAndTransactionService.returnAllTransactionsByAccount(STRING_ID));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Transaction.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(STRING_ID, response.get(INDEX).getTransactionId());
        assertEquals(STRING_ID, response.get(INDEX).getAccountId());
        assertEquals(PRODUCT_IDENTIFIER_ENUM, response.get(INDEX).getProductIdentifier());
        assertEquals(AMOUNT, response.get(INDEX).getAmount());
        assertEquals(CREDIT_DEBIT_INDICATOR_ENUM, response.get(INDEX).getCreditDebitIndicator());
        assertEquals(STRING_ID, response.get(INDEX).getOriginatorAccount());
        assertEquals(STRING_ID, response.get(INDEX).getEndToEndIdentification());
        assertEquals(STRING_ID, response.get(INDEX).getInstructionIdentification());
        assertEquals(DATE, response.get(INDEX).getBookingDateTime());
        assertEquals(DATE, response.get(INDEX).getValueDateTime());
        assertEquals("A", response.get(INDEX).getTransactionInformation());
        assertEquals(MERCHANT_DETAILS, response.get(INDEX).getMerchantDetails());
    }

    @Test
    void whenFindAllThenReturnAnListOfDirectDebitsBasicInfo() {
        when(directDebitDetailedInfoRepository.findAll()).thenReturn(new ArrayList<>(List.of(directDebitDetailedInfo)));

        List<DirectDebitBasicInfo> response = new ArrayList<>(accountAndTransactionService.returnAllDirectDebitByAccount(STRING_ID));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(DirectDebitBasicInfo.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(STRING_ID, response.get(INDEX).getDirectDebitId());
        assertEquals(STRING_ID, response.get(INDEX).getAccountId());
        assertEquals("C", response.get(INDEX).getProductName());
        assertEquals(STATUS_ENUM, response.get(INDEX).getStatus());
    }

    private void startBalances() {
        balancesResponse = new BalancesResponse(ID, new ArrayList<>());
        balancesResponseDTO = new BalancesResponseDTO(ID, new ArrayList<>());

    }

    private void startCard() {
        card = new Card(ID, "4567456745674567", "Jose", "1234", DATE, "VISA", 123, false, "1");
    }

    private void startTransaction() {
        transaction = new Transaction(STRING_ID, STRING_ID, PRODUCT_IDENTIFIER_ENUM, AMOUNT, CREDIT_DEBIT_INDICATOR_ENUM,
               "1", "1", "1", DATE, DATE, "A", MERCHANT_DETAILS);
    }

    private void startDirectDebit() {
        directDebitDetailedInfo = new DirectDebitDetailedInfo(STRING_ID, "A", STRING_ID, "B",
                "C", STATUS_ENUM, DATE, AMOUNT);
        optionalDirectDebitDetailedInfo = Optional.of(new DirectDebitDetailedInfo(STRING_ID, "A", STRING_ID,
                "B", "C", STATUS_ENUM, DATE, AMOUNT));
    }


}