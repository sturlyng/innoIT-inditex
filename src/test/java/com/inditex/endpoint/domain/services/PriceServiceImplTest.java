package com.inditex.endpoint.domain.services;

import com.inditex.endpoint.BaseTest;
import com.inditex.endpoint.domain.entities.Price;
import com.inditex.endpoint.domain.exception.PriceNotFoundException;
import com.inditex.endpoint.domain.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class PriceServiceImplTest extends BaseTest {

    public static final LocalDateTime SPECIAL_LOCAL_DATE_TIME = LocalDateTime.of(2024, 04, 01, 00, 00, 00);
    public static final LocalDateTime SPECIAL_START_LOCAL_DATE_TIME = LocalDateTime.of(2024, 04, 01, 00, 00, 00);
    public static final LocalDateTime SPECIAL_END_LOCAL_DATE_TIME = LocalDateTime.of(2024, 04, 01, 00, 59, 59);
    public static final LocalDateTime NORMAL_START_LOCAL_DATE_TIME = LocalDateTime.of(2024, 01, 1, 00, 00, 00);
    public static final LocalDateTime NORMAL_END_LOCAL_DATE_TIME = LocalDateTime.of(2024, 12, 31, 11, 59, 59);
    public static final Integer PRODUCT_ID = 1;
    public static final Integer BRAND_ID = 1;

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testFindPriceGettingSpecialPriceByPriority() throws PriceNotFoundException {

        Price expectedPrice = createPrice();

        when(priceRepository.findPrice(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(Optional.of(expectedPrice));

        Price price = priceService.findPrice(SPECIAL_LOCAL_DATE_TIME, PRODUCT_ID, BRAND_ID);

        assertEquals(1, price.getProductId());
        assertEquals(1, price.getBrandId());
        assertEquals(2, price.getPriceList());
        assertEquals(SPECIAL_START_LOCAL_DATE_TIME, price.getStartDate());
        assertEquals(SPECIAL_END_LOCAL_DATE_TIME, price.getEndDate());
        assertEquals(14.1, price.getPrice());

        verify(priceRepository, times(1)).findPrice(SPECIAL_LOCAL_DATE_TIME, PRODUCT_ID, BRAND_ID);
    }

    @Test
    void testFindPriceWhenPriceNotFound() {

        when(priceRepository.findPrice(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(Optional.empty());

        assertThrows(PriceNotFoundException.class, () -> {
            priceService.findPrice(SPECIAL_LOCAL_DATE_TIME, PRODUCT_ID, BRAND_ID);
        });

        verify(priceRepository, times(1)).findPrice(SPECIAL_LOCAL_DATE_TIME, PRODUCT_ID, BRAND_ID);
    }

    private Price createPrice() {

        return Price.builder()
                        .id(2)
                        .brandId(BRAND_ID)
                        .startDate(SPECIAL_START_LOCAL_DATE_TIME)
                        .endDate(SPECIAL_END_LOCAL_DATE_TIME)
                        .priceList(2)
                        .productId(PRODUCT_ID)
                        .priority(1)
                        .price(14.1)
                        .curr("EUR")
                        .build();
    }

}
