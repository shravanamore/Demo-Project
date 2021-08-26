package com.example.demo.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="product_id")
	private int vendorId;

	@Column(name="qty_placed")
	private int quantityPlaced;
	
	@Column(name="qty_delivered")
	private int quantityDelivered;
	
	@Column(name="price")
	private int price;
	
	@Column(name="currency")
	private String currency;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="order_id")
	private PurchaseOrder purchaseOrder;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	public OrderProduct() {
		
	}

	public OrderProduct(int vendorId, int quantityPlaced, int quantityDelivered, int price, String currency) {
		super();
		this.vendorId = vendorId;
		this.quantityPlaced = quantityPlaced;
		this.quantityDelivered = quantityDelivered;
		this.price = price;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getQuantityPlaced() {
		return quantityPlaced;
	}

	public void setQuantityPlaced(int quantityPlaced) {
		this.quantityPlaced = quantityPlaced;
	}

	public int getQuantityDelivered() {
		return quantityDelivered;
	}

	public void setQuantityDelivered(int quantityDelivered) {
		this.quantityDelivered = quantityDelivered;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", vendorId=" + vendorId + ", quantityPlaced=" + quantityPlaced
				+ ", quantityDelivered=" + quantityDelivered + ", price=" + price + ", currency=" + currency + "]";
	}
	
	
	
	

	
	
	
	
	
}



