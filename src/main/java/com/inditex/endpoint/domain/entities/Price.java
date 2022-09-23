package com.inditex.endpoint.domain.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Price {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
    private Integer brand_id;
	
	@Column(nullable = false)
    private Instant start_date;
	
	@Column(nullable = false)
    private Instant end_date;
	
	@Column(nullable = false)
    private Integer price_list;
	
	@Column(nullable = false)
    private Integer product_id;
	
	@Column(nullable = false)
    private Integer priority;
	
	@Column(nullable = false)
    private Integer price;
	
	@Column(nullable = false)
    private String curr;
	
}
