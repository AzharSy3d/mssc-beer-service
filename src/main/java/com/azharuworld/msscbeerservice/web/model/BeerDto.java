package com.azharuworld.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private OffsetDateTime insertedDate;
    private OffsetDateTime lastModifiedDate;
    private Integer quantityInHand;
    private BigDecimal price;
}
