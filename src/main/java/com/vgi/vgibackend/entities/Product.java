package com.vgi.vgibackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "product_name")
	private String productName;

	private Double price;
	
	@Column(name = "image_url",length = 1000)
	private String productImageURL;
	@Column(name = "brand_id")
	private Integer brandId;
	
	@Column(length = 3000)
	private String bulletpoints;
	
	@Transient
	private String brandname;
	
	private String uniqueId;
}