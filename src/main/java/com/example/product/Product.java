package com.example.product;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private Float productPrice;
	private String productQuantity;
	@CreationTimestamp
	@Column(name="created_date",updatable = false)
	private Date productCreatedDate;
	@UpdateTimestamp
	@Column(name="updated_date",insertable=false)
	private Date productUpdatedDate;
	
	
}
