package com.inditex.endpoint.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.inditex.endpoint.boot.config.entity.RestConfig;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Price implements Serializable {

	private static final long serialVersionUID = 4988414277982639616L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
    private Integer brandId;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = RestConfig.DATE_PATTERN)
    private Date startDate;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = RestConfig.DATE_PATTERN)
    private Date endDate;
	
	@Column(nullable = false)
    private Integer priceList;
	
	@Column(nullable = false)
    private Integer productId;
	
	@Column(nullable = false)
    private Integer priority;
	
	@Column(nullable = false)
    private Double price;
	
	@Column(nullable = false)
    private String curr;
	
}
