package com.foursys.fourcamp.alphabank.controller;

import com.foursys.fourcamp.alphabank.dto.BankAtmsDTO;
import com.foursys.fourcamp.alphabank.entities.BankAtms;
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

import java.util.ArrayList;
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
    public static final String SETTLEMENTTYPE = "Seinao";
    public static final Long ID = 1L;
    public static final Integer INDEX = 0;

    @InjectMocks
    private OpenDataController controller;

    @Mock
    private ModelMapper mapper;

    @Mock
    private OpenDataService service;

    private BankAtms bankAtms = new BankAtms();

    private BankAtmsDTO bankAtmsDTO = new BankAtmsDTO();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startAtms();
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
        assertEquals(ArrayList.class, response.getBody().getClass());
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

    private void startAtms() {
        bankAtms = new BankAtms(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
        bankAtmsDTO = new BankAtmsDTO(ID, NAME, CITY, REGION, ADDRESS, ZIPCODE, ACCESS, LAT, LON, SETTLEMENTTYPE);
    }
}