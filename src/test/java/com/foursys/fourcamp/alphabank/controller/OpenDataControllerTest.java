package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.service.OpenDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
class OpenDataControllerTest {
    public static final String NAME = "CaixaEletronico";
    public static final String CITY = "Recife";
    public static final String REGION = "REGIAOTOP";
    public static final String ADDRESS = "EnderecoTeste";
    public static final String ZIPCODE = "10235654";
    public static final String ACCESS = "Acessado";
    public static final Integer LAT = 10;
    public static final Integer LON = 35;

    public static final Date DATE = new Date();
    public static final String SETTLEMENTTYPE = "Seinao";
    public static final Long ID = 1L;
    public static final Integer INDEX = 0;
    public static final  Boolean ISINBRANCH = true;
    public static final Double LATAKPS = 10.0;
    public static final Double LONAKPS = 35.0;
    public static final String COUNTRY = "Brasil";
    public static final String PHONE = "449999911445";
    public static final String FAX = "123456877";
    public static final Currency CURRENCY = new Currency();
    @InjectMocks
    private OpenDataController controller;

    @Mock
    private ModelMapper mapper;

    @Mock
    private OpenDataService service;

    private CurrencyRate currencyRate = new CurrencyRate();

    private Akps akps = new Akps();
    private BankAtms bankAtms = new BankAtms();

    private BankAtmsDTO bankAtmsDTO = new BankAtmsDTO();

    private BranchList branchList = new BranchList();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAtms();
        startAkps();
        startBranch();
        startCurrencyRate();
    }

    @Test
    void whenFindAllThenReturnLitOfBankAtmDTO() {
        when(service.findAllAtms()).thenReturn(List.of(bankAtms));
        when(mapper.map(any(), any())).thenReturn(bankAtmsDTO);

        ResponseEntity<List<BankAtmsDTO>> response = controller.returnBankAtms();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(BankAtmsDTO.class, response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(CITY, response.getBody().get(INDEX).getCity());
        assertEquals(REGION, response.getBody().get(INDEX).getRegion());
        assertEquals(ADDRESS, response.getBody().get(INDEX).getAddress());
        assertEquals(ZIPCODE, response.getBody().get(INDEX).getZipcode());
        assertEquals(ACCESS, response.getBody().get(INDEX).getAccess());
        assertEquals(LAT, response.getBody().get(INDEX).getLat());
        assertEquals(LON, response.getBody().get(INDEX).getLon());
        assertEquals(SETTLEMENTTYPE, response.getBody().get(INDEX).getSettlementType());
    }
    @Test
    void whenFindAllThenReturnAnListOfAkps() {
        when(service.listAllAkpsBank()).thenReturn(List.of(akps));
        ResponseEntity<List<Akps>> response = controller.listAllAkpsBank();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(CITY, response.getBody().get(INDEX).getCity());
        assertEquals(ADDRESS, response.getBody().get(INDEX).getAndress());
        assertEquals(ZIPCODE, response.getBody().get(INDEX).getZipCode());
        assertEquals(ISINBRANCH, response.getBody().get(INDEX).getIsInBranch());
        assertEquals(LATAKPS, response.getBody().get(INDEX).getLat());
        assertEquals(LONAKPS, response.getBody().get(INDEX).getLon());
    }

    @Test
    void whenFindAllThenReturnAnListOfBranchs() {
        when(service.findAllBranch()).thenReturn(List.of(branchList));
        ResponseEntity<List<BranchList>> response = controller.returnBankBranches();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(CITY, response.getBody().get(INDEX).getCity());
        assertEquals(REGION, response.getBody().get(INDEX).getRegion());
        assertEquals(COUNTRY, response.getBody().get(INDEX).getCountry());
        assertEquals(ADDRESS, response.getBody().get(INDEX).getAddress());
        assertEquals(ZIPCODE, response.getBody().get(INDEX).getZipCode());
        assertEquals(PHONE, response.getBody().get(INDEX).getPhone());
        assertEquals(FAX, response.getBody().get(INDEX).getFax());
        assertEquals(LAT, response.getBody().get(INDEX).getLat());
        assertEquals(LON, response.getBody().get(INDEX).getLon());
    }

    @Test
    void whenFindByIdThenReturnAnCurrencyRateInstance() {
        when(service.returnBankCurrencyRates()).thenReturn(currencyRate);

        ResponseEntity<CurrencyRate> response = controller.returnBankCurrencyRates();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(DATE, response.getBody().getExchangeRatesDate());
        assertEquals(DATE, response.getBody().getEcbrRatesDate());
        assertEquals(CURRENCY, response.getBody().getCurrencies());
    }

    private void startAtms() {
        bankAtms = new BankAtms(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
        bankAtmsDTO = new BankAtmsDTO(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
    }
    private void startAkps(){
        akps = new Akps(ID , NAME, CITY, ADDRESS, ZIPCODE, ISINBRANCH, LATAKPS, LONAKPS);
    }

    private void startBranch(){
        branchList = new BranchList(ID, NAME, CITY, REGION, COUNTRY, ADDRESS, ZIPCODE, PHONE, FAX, LAT, LON);
    }

    private void startCurrencyRate() {
        currencyRate = new CurrencyRate(ID, DATE, DATE, CURRENCY);
    }


}