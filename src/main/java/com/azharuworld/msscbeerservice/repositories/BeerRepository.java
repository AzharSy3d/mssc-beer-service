package com.azharuworld.msscbeerservice.repositories;

import com.azharuworld.msscbeerservice.domain.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * * Created by AzSyed on 12/29/2020
 */
public interface BeerRepository extends CrudRepository<Beer, UUID> {
}
