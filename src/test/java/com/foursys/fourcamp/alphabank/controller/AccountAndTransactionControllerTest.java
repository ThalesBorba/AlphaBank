package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BalancesResponseDTO;
import com.foursys.fourcamp.alphabank.entities.AccountRequest;
import com.foursys.fourcamp.alphabank.entities.BalancesResponse;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.CreditDebitIndicatorEnum;
import com.foursys.fourcamp.alphabank.enums.ProductIdentifierEnum;
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
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountAndTransactionControllerTest {

    public static final Long ID = 1L;
    public static final String STRING_ID = "1";
    public static final int INDEX = 0;

    public static final Date DATE = Date.valueOf("2022-07-19");
    private BalancesResponse balancesResponse = new BalancesResponse();
    private BalancesResponseDTO balancesResponseDTO = new BalancesResponseDTO();

    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM = ProductIdentifierEnum.ACCOUNT;

    public static final CreditDebitIndicatorEnum CREDIT_DEBIT_INDICATOR_ENUM = CreditDebitIndicatorEnum.CREDIT;

    public static final Amount AMOUNT = new Amount();

    public static final MerchantDetails MERCHANT_DETAILS = new MerchantDetails();

    @InjectMocks
    private AccountAndTransactionController accountAndTransactionController;

    @Mock
    private ModelMapper mapper;

    @Mock
    private AccountAndTransactionService accountAndTransactionService;

    private Card card;

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
        startCard();
        startTransaction();
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
//    public ResponseEntity deleteAccountRequest(@PathVariable Long accountRequestId) {
//        accountAndTransactionService.deleteAccountRequest(accountRequestId);
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//
//    }
    @Test
   void testarOResponseAccountRequestController(){
        doNothing().when(accountAndTransactionService).deleteAccountRequest(anyLong());
        ResponseEntity<AccountRequest> response=accountAndTransactionController.deleteAccountRequest(ID);
        assertNotNull(response);
        assertEquals(ResponseEntity.class,response.getClass());
        assertEquals(HttpStatus.NO_CONTENT,response.getStatusCode());
        verify(accountAndTransactionService,times(1)).deleteAccountRequest(anyLong());

    }


    @Test
    void whenFindAllThenReturnListOfCards() {
        when(accountAndTransactionService.returnAllCardsByAccount(STRING_ID)).thenReturn(new ArrayList<>(List.of(card)));

        ResponseEntity<List<Card>> response = accountAndTransactionController.returnAllCards(STRING_ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(Card.class, response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(STRING_ID, response.getBody().get(INDEX).getAccountId());

    }

    @Test
    void whenFindAllThenReturnListOfTransactions() {
        when(accountAndTransactionService.returnAllTransactionsByAccount(STRING_ID)).thenReturn(
                new ArrayList<>(List.of(transaction)));

        ResponseEntity<List<Transaction>> response = accountAndTransactionController.returnAccountTransactions(STRING_ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(Transaction.class, response.getBody().get(INDEX).getClass());

        assertEquals(STRING_ID, response.getBody().get(INDEX).getTransactionId());
        assertEquals(STRING_ID, response.getBody().get(INDEX).getAccountId());

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
}