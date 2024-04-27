package com.inditex.endpoint.domain.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime startDate;
	
	@Column(nullable = false, name = "end_date")
    private LocalDateTime endDate;
	
	@Column(nullable = false, name = "price_list")
    private Integer priceList;
	
	@Column(nullable = false, name = "product_id")
    private Integer productId;
	
	@Column(nullable = false, name = "priority_order")
    private Integer priority;
	
	@Column(nullable = false, name = "price")
    private Double price;
	
	@Column(nullable = false, name = "curr")
    private String curr;
	
}
