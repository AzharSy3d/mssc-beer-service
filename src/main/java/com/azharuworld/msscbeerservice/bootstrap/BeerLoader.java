package com.azharuworld.msscbeerservice.bootstrap;

import com.azharuworld.msscbeerservice.domain.Beer;
import com.azharuworld.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * * Created by AzSyed on 12/29/2020
 */
@Component
@Slf4j
public class BeerLoader implements CommandLineRunner {

    private BeerRepository beerRepository;

    @Autowired
    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeerObjects();

    }

    private  void loadBeerObjects(){
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Soda")
                    .beerStyle("API")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .price(BigDecimal.valueOf(20))
                    .upc(123213214L)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Hard")
                    .quantityToBrew(100)
                    .minOnHand(6)
                    .price(BigDecimal.valueOf(40))
                    .upc(123213215L)
                    .build());
        }
        log.info("Count of BeerRepo "+beerRepository.count());

    }
}
