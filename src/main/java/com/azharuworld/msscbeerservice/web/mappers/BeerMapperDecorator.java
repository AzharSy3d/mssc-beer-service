package com.azharuworld.msscbeerservice.web.mappers;

import com.azharuworld.msscbeerservice.domain.Beer;
import com.azharuworld.msscbeerservice.services.inventory.BeerInventoryService;
import com.azharuworld.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * * Created by AzSyed on 4/25/2021
 */

public abstract class BeerMapperDecorator implements BeerMapper {
    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        BeerDto beerDto = beerMapper.beerToBeerDto(beer);
        beerDto.setQuantityInHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return  beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }


}
