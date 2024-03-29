package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.entities.*;
import com.foursys.fourcamp.alphabank.repository.AkpsRepository;
import com.foursys.fourcamp.alphabank.repository.BankAtmsRepository;
import com.foursys.fourcamp.alphabank.repository.BranchListRepository;
import com.foursys.fourcamp.alphabank.repository.CurrencyRateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class OpenDataServiceTest {
    public static final String NAME = "CaixaEletronico";
    public static final String CITY = "Recife";
    public static final String REGION = "REGIAOTOP";
    public static final String ADDRESS = "EnderecoTeste";
    public static final String ZIPCODE = "10235654";
    public static final String ACCESS = "Acessado";
    public static final Integer LAT = 10;
    public static final Integer LON = 35;
    public static final Double LATAKPS = 10.0;
    public static final Double LONAKPS = 35.0;
    public static final String SETTLEMENTTYPE = "Seinao";
    public static final Long ID = 1L;
    public static final  Boolean ISINBRANCH = true;
    public static final Date DATE = new Date();
    public static final String COUNTRY = "Brasil";
    public static final String PHONE = "449999911445";
    public static final String FAX = "123456877";
    public static final Currency CURRENCY = new Currency();
    public static final int INDEX = 0;

    @InjectMocks
    private OpenDataService openDataService;

    @Mock
    private BankAtmsRepository bankAtmsRepository;

    @Mock
    private AkpsRepository akpsRepository;

    @Mock
    private BranchListRepository branchListRepository;

    @Mock
    private CurrencyRateRepository currencyRateRepository;

    @Mock
    private ModelMapper mapper;

    private Optional<CurrencyRate> optionalCurrencyRate;

    private BankAtms bankAtms;

    private Akps akps;

    private BranchList branchList;

    private CurrencyRate currencyRate;

    private BankAtmsDTO bankAtmsDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAtms();
        startAkps();
        startBranch();
        startCurrencyRate();
    }

    @Test
    void whenFinAllThenReturnAnListOfAtms() {
        when(bankAtmsRepository.findAll()).thenReturn(List.of(bankAtms));

        List<BankAtms> response = openDataService.findAllAtms();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(BankAtms.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(CITY, response.get(INDEX).getCity());
        assertEquals(REGION, response.get(INDEX).getRegion());
        assertEquals(ADDRESS, response.get(INDEX).getAddress());
        assertEquals(ZIPCODE, response.get(INDEX).getZipcode());
        assertEquals(ACCESS, response.get(INDEX).getAccess());
        assertEquals(LAT, response.get(INDEX).getLat());
        assertEquals(LON, response.get(INDEX).getLon());
        assertEquals(SETTLEMENTTYPE, response.get(INDEX).getSettlementType());

    }

    @Test
    void whenFindAllThenReturnAnListOfAkps() {
        when(akpsRepository.findAll()).thenReturn(List.of(akps));
        List<Akps> response = openDataService.listAllAkpsBank();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Akps.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(CITY, response.get(INDEX).getCity());
        assertEquals(ADDRESS, response.get(INDEX).getAndress());
        assertEquals(ZIPCODE, response.get(INDEX).getZipCode());
        assertEquals(ISINBRANCH, response.get(INDEX).getIsInBranch());
        assertEquals(LATAKPS, response.get(INDEX).getLat());
        assertEquals(LONAKPS, response.get(INDEX).getLon());
    }

    @Test
    void whenFindAllThenReturnAnListOfBranchs() {
        when(branchListRepository.findAll()).thenReturn(List.of(branchList));
        List<BranchList> response = openDataService.findAllBranch();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(BranchList.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(CITY, response.get(INDEX).getCity());
        assertEquals(REGION, response.get(INDEX).getRegion());
        assertEquals(COUNTRY, response.get(INDEX).getCountry());
        assertEquals(ADDRESS, response.get(INDEX).getAddress());
        assertEquals(ZIPCODE, response.get(INDEX).getZipCode());
        assertEquals(PHONE, response.get(INDEX).getPhone());
        assertEquals(FAX, response.get(INDEX).getFax());
        assertEquals(LAT, response.get(INDEX).getLat());
        assertEquals(LON, response.get(INDEX).getLon());
    }

    @Test
    void whenFindByIdThenReturnAnCurrencyRateInstance() {
        when(currencyRateRepository.findById(anyLong())).thenReturn(optionalCurrencyRate);

        CurrencyRate response = openDataService.returnBankCurrencyRates();

        Assertions.assertNotNull(response);
        assertEquals(CurrencyRate.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(DATE, response.getExchangeRatesDate());
        assertEquals(DATE, response.getEcbrRatesDate());
        assertEquals(CURRENCY, response.getCurrencies());
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
        optionalCurrencyRate = Optional.of(new CurrencyRate(ID, DATE, DATE, CURRENCY));
    }


}