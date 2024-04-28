package com.inditex.endpoint.domain.entities;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price implements Serializable {

	@Serial
	private static final long serialVersionUID = 4988414277982639616L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, name = "brand_id")
    private Integer brandId;
	
	@Column(nullable = false, name = "start_date")
    private Instant startDate;
	
	@Column(nullable = false, name = "end_date")
    private Instant endDate;
	
	@Column(nullable = false, name = "price_list")
    private Integer priceList;
	
	@Column(nullable = false, name = "product_id")
    private Integer productId;
	
	@Column(nullable = false, name = "priority_order")
    private Integer priority;
	
	@Column(nullable = false, name = "price", precision = 20, scale = 2)
    private BigDecimal price;
	
	@Column(nullable = false, name = "curr")
    private String curr;
	
}
