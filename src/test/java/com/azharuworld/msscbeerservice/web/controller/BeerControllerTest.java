package com.azharuworld.msscbeerservice.web.controller;

import com.azharuworld.msscbeerservice.bootstrap.BeerLoader;
import com.azharuworld.msscbeerservice.services.BeerService;
import com.azharuworld.msscbeerservice.web.model.BeerDto;
import com.azharuworld.msscbeerservice.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;



    @Test
    void getBeer() throws Exception{
        given(beerService.getById(any())).willReturn(getValidBeerDto());

        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJSON = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(beerDto)).willReturn(getValidBeerDto());

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoToJSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws  Exception{
        BeerDto beerDto = getValidBeerDto();
        String beerDtoToJSON = objectMapper.writeValueAsString(beerDto);

        given(beerService.updateBeer(any(),any())).willReturn(getValidBeerDto());

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoToJSON))
                .andExpect(status().isNoContent());
    }

    private BeerDto getValidBeerDto(){
        return BeerDto.builder().beerName("My New Beer").beerStyle(BeerStyleEnum.valueOf("PALE_ALE")).price(BigDecimal.valueOf(2.33)).upc(BeerLoader.BEER_UPC_1).build();
    }
}