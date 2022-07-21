package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.*;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.enums.*;
import com.foursys.fourcamp.alphabank.exceptions.ObjectNotFoundException;
import com.foursys.fourcamp.alphabank.repository.*;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountAndTransactionServiceTest {

    public static final Long ID = 1L;
    public static final String STRING_ID = "1";
    public static final int INDEX = 0;

    public static final ProductIdentifier PRODUCT_IDENTIFIER = new ProductIdentifier();

    public static final Risk RISK = new Risk();

    public static final Date DATE = Date.valueOf("2022-07-19");

    @InjectMocks
    private AccountAndTransactionService accountAndTransactionService;

    @Mock
    private BalancesResponseRepository balancesResponseRepository;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private CardRepository cardRepository;

    @Mock
    private AccountsResponseRepository accountsResponseRepository;
    @Mock
    private DirectDebitDetailedInfoRepository directDebitDetailedInfoRepository;

    @Mock
    private TransactionsRepository transactionsRepository;

    @Mock
    private BeneficiariesRepository beneficiariesRepository;

    @Mock
    private ModelMapper mapper;

    @Mock
    private StandingOrderRepository standingOrderRepository;

    @Mock
    private AccountRequestRepository accountRequestRepository;

    public static final StatusEnum STATUS_ENUM = StatusEnum.PENDING;

    public static final AccountProfile ACCOUNT_PROFILE = new AccountProfile();

    public static final Servicer SERVICER = new Servicer();
    public static final ProductIdentifierEnum PRODUCT_IDENTIFIER_ENUM = ProductIdentifierEnum.ACCOUNT;

    public static final CreditDebitIndicatorEnum CREDIT_DEBIT_INDICATOR_ENUM = CreditDebitIndicatorEnum.CREDIT;

    public static final Amount AMOUNT = new Amount();

    public static final MerchantDetails MERCHANT_DETAILS = new MerchantDetails();

    public static final CreditorAccount CREDITOR_ACCOUNT = new CreditorAccount();

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    public static final ExecutionPlan EXECUTION_PLAN = new ExecutionPlan();

    public static final OrderExecution ORDER_EXECUTION = new OrderExecution();

    public static final CustomerTypeEnum CUSTOMER_TYPE_ENUM = CustomerTypeEnum.INDIVIDUAL;

    public static final LanguageEnum LANGUAGE_ENUM = LanguageEnum.EL;

    public static final GenderEnum GENDER_ENUM = GenderEnum.MALE;
    public static final TaxInformation TAX_INFORMATION = new TaxInformation();
    public static final PersonalIdentity PERSONAL_IDENTITY = new PersonalIdentity();
    public static final List<Contact> CONTACTS = new ArrayList<>();
    public static final List<Adress> ADRESSES = new ArrayList<>();


    private BalancesResponseDTO balancesResponseDTO;

    private DirectDebitDetailedInfo directDebitDetailedInfo;

    private StandingOrderDetailedInfo standingOrderDetailedInfo;

    private BalancesResponse balancesResponse;

    private AccountsResponse accountsResponse;
    private AccountsResponseDTO accountsResponseDTO;
    private Beneficiary beneficiary;

    private StandingOrderDetailedDTO standingOrderDetailedDTO;

    private AccountRequest accountRequest;

    private Account account;
    private AccountRequestDTO accountRequestDTO;

    private Optional<Account> optionalAccount;
    private Optional<DirectDebitDetailedInfo> optionalDirectDebitDetailedInfo;

    private Optional<StandingOrderDetailedInfo> optionalStandingOrderDetailedInfo;

    private Optional<Beneficiary> optionalBeneficiary;

    private Optional<StandingOrderDetailedDTO> optionalStandingOrderDetailedDTO;
    private Card card;

    private Transaction transaction;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startBalances();
        startCard();
        startTransaction();
        startDirectDebit();
        startStandingOrder();
        startBeneficiaries();
        startAccountRequest();
        startAccountResponse();
        startAccount();
    }

    @Test
    void whenCreateAccountRequestThenSucess() {
        when(accountRequestRepository.save(any())).thenReturn(accountRequest);

        AccountRequest response = accountAndTransactionService.createAccountRequest(accountRequestDTO);

        assertNotNull(response);
        assertEquals(AccountRequest.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(PRODUCT_IDENTIFIER, response.getProductIdentifier());
        assertEquals(RISK, response.getRisk());
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
    void whenFindAllThenReturnAnListAccountResponse() {
        when(accountsResponseRepository.findAll()).thenReturn(List.of(accountsResponse));

        List<AccountsResponse> response = accountAndTransactionService.findAllAccountsResponse();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(AccountsResponse.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(ACCOUNT_PROFILE, response.get(INDEX).getAccountProfile());
        assertEquals(SERVICER, response.get(INDEX).getServicer());

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
        when(directDebitDetailedInfoRepository.findAll()).thenReturn(List.of(directDebitDetailedInfo));

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
    @Test
    void whenFindByIdThenReturnAccount() {
        when(accountRepository.findById(anyString())).thenReturn(optionalAccount);

        Account response = accountAndTransactionService.findByUserId(STRING_ID);

        assertNotNull(response);
        assertEquals(Account.class, response.getClass());
        assertEquals(ID, response.getUserID());
        assertEquals(ACCOUNT_PROFILE, response.getAccountProfile());
        assertEquals(SERVICER, response.getServicer());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException() {
        when(accountRepository.findById(anyString())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try {
            accountAndTransactionService.findByUserId(STRING_ID);
        } catch(Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfStandingOrderBasicInfo() {
        when(standingOrderRepository.findAll()).thenReturn(List.of(standingOrderDetailedInfo));

        List<StandingOrderBasicInfo> response = new ArrayList<>(accountAndTransactionService.returnAllStandingOrdersByAccount(STRING_ID));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(StandingOrderBasicInfo.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(STRING_ID, response.get(INDEX).getStandingOrderId());
        assertEquals("A", response.get(INDEX).getName());
        assertEquals(STRING_ID, response.get(INDEX).getAccountId());
        assertEquals(AMOUNT, response.get(INDEX).getAmount());
        assertEquals(CREDITOR_ACCOUNT, response.get(INDEX).getCreditorAccount());
    }

    @Test
    void whenFindAllThenReturnAnListOfBeneficiaries() {
        when(beneficiariesRepository.findAll()).thenReturn(List.of(beneficiary));

        List<Beneficiary> response = new ArrayList<>(accountAndTransactionService.returnAllBeneficiariesByAccount(STRING_ID));

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Beneficiary.class, response.get(INDEX).getClass());
        assertEquals(ArrayList.class, response.getClass());
        assertEquals(STRING_ID, response.get(INDEX).getCustomerNumber());
        assertEquals(STRING_ID, response.get(INDEX).getAccountId());
        assertEquals(CUSTOMER_TYPE_ENUM, response.get(INDEX).getCustomerType());
        assertEquals("A", response.get(INDEX).getCompanyName());
        assertEquals("B", response.get(INDEX).getCompanyTitle());
        assertEquals("C", response.get(INDEX).getLastName());
        assertEquals("D", response.get(INDEX).getFirstName());
        assertEquals("E", response.get(INDEX).getFatherName());
        assertEquals(DATE, response.get(INDEX).getBirthDate());
        assertEquals(LANGUAGE_ENUM, response.get(INDEX).getLanguage());
        assertEquals("F", response.get(INDEX).getNationality());
        assertEquals(GENDER_ENUM, response.get(INDEX).getGender());
        assertEquals(TAX_INFORMATION, response.get(INDEX).getTaxInformation());
        assertEquals(PERSONAL_IDENTITY, response.get(INDEX).getPersonalIdentity());
        assertEquals(CONTACTS, response.get(INDEX).getContacts());
        assertEquals(ADRESSES, response.get(INDEX).getAdresses());
        assertEquals("G", response.get(INDEX).getBussinessActivity());
        assertEquals(DATE, response.get(INDEX).getCorpExpirationDate());
        assertEquals(DATE, response.get(INDEX).getLegalEntityExpiryDate());
        assertEquals(DATE, response.get(INDEX).getInsuranceClearanceExpiryDate());
        assertEquals(DATE, response.get(INDEX).getTaxClearanceExpiryDate());
    }

    @Test
    void devedeletarrequisicaodeumaconta(){

        doNothing().when(accountRequestRepository).deleteById(eq(1L));
        when(accountRequestRepository.findById(eq(1L))).thenReturn(Optional.of(new AccountRequest()));

        accountAndTransactionService.deleteAccountRequest(1L);
        verify(accountRequestRepository,times(1)).findById(eq(1L));
        verify(accountRequestRepository,times(1)).deleteById(eq(1L));
        assertThrows(ObjectNotFoundException.class,()->accountAndTransactionService.deleteAccountRequest(2L));

    }
    @Test
    void whenFindByIdAccountAndOrderDetailedThenReturnSucess() {
        when(standingOrderRepository.findByIdAndAccountId(STRING_ID,STRING_ID)).thenReturn(standingOrderDetailedInfo);

        StandingOrderDetailedDTO response = accountAndTransactionService.findByIdOrderDetailed(STRING_ID,STRING_ID);

        assertNotNull(response);
        assertEquals(StandingOrderDetailedDTO.class,response.getClass());
        assertEquals(STRING_ID, response.getAccountId());
        assertEquals("A",response.getName());
        assertEquals(STRING_ID, response.getAccountId());
        assertEquals(AMOUNT, response.getAmount());
        assertEquals(CREDITOR_ACCOUNT, response.getCreditorAccount());

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

    private void startStandingOrder() {
        standingOrderDetailedInfo = new StandingOrderDetailedInfo(STRING_ID, "A", STRING_ID, STATUS_ENUM, DATE, DATE, DATE,
                AMOUNT, CREDITOR_ACCOUNT, "B", EXECUTION_PLAN, ORDER_EXECUTION, ORDER_EXECUTION);
        optionalStandingOrderDetailedInfo = Optional.of(new StandingOrderDetailedInfo(STRING_ID, "A", STRING_ID, STATUS_ENUM, DATE, DATE, DATE,
                AMOUNT, CREDITOR_ACCOUNT, "B", EXECUTION_PLAN, ORDER_EXECUTION, ORDER_EXECUTION));
    }

    private void startBeneficiaries() {
        beneficiary = new Beneficiary(STRING_ID, STRING_ID, CUSTOMER_TYPE_ENUM, "A", "B", "C", "D", "E", DATE, LANGUAGE_ENUM,
                "F", GENDER_ENUM, TAX_INFORMATION, PERSONAL_IDENTITY, CONTACTS, ADRESSES, "G", DATE, DATE, DATE, DATE);
        optionalBeneficiary = Optional.of(beneficiary);
    }

    private void startAccountRequest(){
        accountRequest = new AccountRequest(ID, PRODUCT_IDENTIFIER, RISK);
        accountRequestDTO = new AccountRequestDTO(ID, PRODUCT_IDENTIFIER, RISK);
    }

    private void startAccountResponse() {
        accountsResponse = new AccountsResponse(ID, ACCOUNT_PROFILE, SERVICER);
        accountsResponseDTO = new AccountsResponseDTO(ID, ACCOUNT_PROFILE, SERVICER);
    }

    private void startAccount() {
        account = new Account(ID, ACCOUNT_PROFILE, SERVICER);
        optionalAccount = Optional.of(account);
    }


}