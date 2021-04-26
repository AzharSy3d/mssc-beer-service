package com.azharuworld.msscbeerservice.services;

import com.azharuworld.msscbeerservice.web.model.BeerDto;
import com.azharuworld.msscbeerservice.web.model.BeerPagedList;
import com.azharuworld.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) ;
}
