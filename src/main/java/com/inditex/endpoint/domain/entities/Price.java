package com.inditex.endpoint.domain.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.inditex.endpoint.boot.config.entity.RestConfig;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "prices")
@Data
@Builder
public class Price implements Serializable {

	@Serial
	private static final long serialVersionUID = 4988414277982639616L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, name = "brand_id")
    private Integer brandId;
	
	@Column(nullable = false, name = "start_date")
	//@DateTimeFormat(pattern = RestConfig.DATE_PATTERN)
    private LocalDateTime startDate;
	
	@Column(nullable = false, name = "end_date")
	//@DateTimeFormat(pattern = RestConfig.DATE_PATTERN)
    private LocalDateTime endDate;
	
	@Column(nullable = false, name = "price_list")
    private Integer priceList;
	
	@Column(nullable = false, name = "product_id")
    private Integer productId;
	
	@Column(nullable = false)
    private Integer priority;
	
	@Column(nullable = false, name = "brand_id")
    private Double price;
	
	@Column(nullable = false, name = "brand_id")
    private String curr;
	
}
