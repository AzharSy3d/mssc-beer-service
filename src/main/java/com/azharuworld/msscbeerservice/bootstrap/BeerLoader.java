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

    private final BeerRepository beerRepository;

    public static final String BEER_UPC_1 = "087162143151";
    public static final String BEER_UPC_2 = "087162143152";
    public static final String BEER_UPC_3 = "087162143153";

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
                    .upc(BEER_UPC_1)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Hard")
                    .quantityToBrew(100)
                    .minOnHand(6)
                    .price(BigDecimal.valueOf(40))
                    .upc(BEER_UPC_2)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Amazing Beer")
                    .beerStyle("Hard")
                    .quantityToBrew(100)
                    .minOnHand(6)
                    .price(BigDecimal.valueOf(40))
                    .upc(BEER_UPC_3)
                    .build());
        }
        log.error("Count of BeerRepo "+beerRepository.count());

    }
}
