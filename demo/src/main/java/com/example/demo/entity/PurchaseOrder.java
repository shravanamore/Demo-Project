package com.example.demo.entity;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchaseOrder")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="vendor_id")
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
	@JoinColumn(name="created_by")
	private User user;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
	private List<OrderProduct> productsInOrder;
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
	private List<Invoice> invoices;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	public PurchaseOrder() {
		
	}

	public PurchaseOrder(int vendorId, int quantityPlaced, int quantityDelivered, int price,
			String currency) {
		this.vendorId = vendorId;
		this.quantityPlaced = quantityPlaced;
		this.quantityDelivered = quantityDelivered;
		this.price = price;
		this.currency = currency;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderProduct> getProductsInOrder() {
		return productsInOrder;
	}

	public void setProductsInOrder(List<OrderProduct> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}
	
	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
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

	public void addProduct(OrderProduct orderProduct) {
		if (productsInOrder == null) {
			productsInOrder = new ArrayList<>();
		}

		productsInOrder.add(orderProduct);

		orderProduct.setPurchaseOrder(this);
	}
	
	public void addInvoice(Invoice invoice) {
		if (invoices == null) {
			invoices = new ArrayList<>();
		}

		invoices.add(invoice);

		invoice.setPurchaseOrder(this);
	}

	@Override
	public String toString() {
		return "purchaseOrder [orderId=" + orderId + ", vendorId=" + vendorId + ", quantityPlaced=" + quantityPlaced
				+ ", quantityDelivered=" + quantityDelivered + ", price=" + price + ", currency=" + currency + "]";
	}
	
}



