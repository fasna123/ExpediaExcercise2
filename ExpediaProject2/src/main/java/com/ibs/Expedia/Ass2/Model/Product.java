package com.ibs.Expedia.Ass2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {
	@Id
	private long id;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "ProductDescrip")
	private String productDesc;
	@Column(name = "ProductPrice")
	private double productPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "id=" + id + ", productName=" + productName + ", productDesc=" + productDesc + ", productPrice="
				+ productPrice+"\n";
	}

}
