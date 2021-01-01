package com.azharuworld.msscbeerservice.web.mappers;

import com.azharuworld.msscbeerservice.domain.Beer;
import com.azharuworld.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto beerDto);
}
