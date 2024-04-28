package com.inditex.endpoint.domain.services;

import com.inditex.endpoint.BaseTest;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PriceServiceImplTest extends BaseTest {

    public static final LocalDateTime SPECIAL_LOCAL_DATE_TIME = LocalDateTime.of(2024, 4, 1, 0, 0, 0);
    public static final LocalDateTime SPECIAL_START_LOCAL_DATE_TIME = LocalDateTime.of(2024, 4, 1, 0, 0, 0);
    public static final LocalDateTime SPECIAL_END_LOCAL_DATE_TIME = LocalDateTime.of(2024, 4, 1, 0, 59, 59);
    public static final Integer PRODUCT_ID = 1;
    public static final Integer BRAND_ID = 1;

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testFindPriceGettingSpecialPriceByPriority() throws PriceNotFoundException {

        Price expectedPrice = createPrice();

        when(priceRepository.findPrice(any(Instant.class), anyInt(), anyInt())).thenReturn(Optional.of(expectedPrice));

        Price price = priceService.findPrice(toInstantSpain(SPECIAL_LOCAL_DATE_TIME), PRODUCT_ID, BRAND_ID);

        assertEquals(1, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(2, price.getPriceList());
        assertEquals(toInstantSpain(SPECIAL_START_LOCAL_DATE_TIME), price.getStartDate());
        assertEquals(toInstantSpain(SPECIAL_END_LOCAL_DATE_TIME), price.getEndDate());
        assertEquals(new BigDecimal("14.1"), price.getPrice());

        verify(priceRepository, times(1)).findPrice(toInstantSpain(SPECIAL_LOCAL_DATE_TIME), PRODUCT_ID, BRAND_ID);
    }

    @Test
    void testFindPriceWhenPriceNotFound() {

        when(priceRepository.findPrice(any(Instant.class), anyInt(), anyInt())).thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () -> {
            priceService.findPrice(toInstantSpain(SPECIAL_LOCAL_DATE_TIME), PRODUCT_ID, BRAND_ID);
        });

        verify(priceRepository, times(1)).findPrice(toInstantSpain(SPECIAL_LOCAL_DATE_TIME), PRODUCT_ID, BRAND_ID);
    }

    private Price createPrice() {

        return Price.builder()
                        .id(2)
                        .brandId(BRAND_ID)
                        .startDate(toInstantSpain(SPECIAL_START_LOCAL_DATE_TIME))
                        .endDate(toInstantSpain(SPECIAL_END_LOCAL_DATE_TIME))
                        .priceList(2)
                        .productId(PRODUCT_ID)
                        .priority(1)
                        .price(new BigDecimal("14.1"))
                        .curr("EUR")
                        .build();
    }

}
