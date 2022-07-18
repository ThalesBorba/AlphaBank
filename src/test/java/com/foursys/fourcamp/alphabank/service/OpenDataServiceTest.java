package com.foursys.fourcamp.alphabank.service;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.entities.BankAtms;
import com.foursys.fourcamp.alphabank.dto.repository.BankAtmsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public static final String SETTLEMENTTYPE = "Seinao";
    public static final Long ID = 1L;

    public static final int INDEX = 0;

    @InjectMocks
    private OpenDataService service;

    @Mock
    private BankAtmsRepository bankAtmsRepository;

    @Mock
    private ModelMapper mapper;

    private BankAtms bankAtms;

    private BankAtmsDTO bankAtmsDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAtms();
    }

    @Test
    void whenFinAllThenReturnAnListOfAtms() {
        when(bankAtmsRepository.findAll()).thenReturn(List.of(bankAtms));

        List<BankAtms> response = bankAtmsRepository.findAll();

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

    private void startAtms() {
        bankAtms = new BankAtms(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
        bankAtmsDTO = new BankAtmsDTO(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
    }

}