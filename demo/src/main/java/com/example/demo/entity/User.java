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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
	private List<PurchaseOrder> purchaseOrders;
	
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
	private List<Invoice> invoices;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Vendor> vendors;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Product> products;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<OrderProduct> orderProductMappings;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<InvoiceProduct> invoiceProducts;

	public User() {

	}

	public User(String userName, String firstName, String lastName, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
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

	
	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<OrderProduct> getOrderProductMappings() {
		return orderProductMappings;
	}

	public void setOrderProductMappings(List<OrderProduct> orderProductMappings) {
		this.orderProductMappings = orderProductMappings;
	}

	public List<InvoiceProduct> getInvoiceProducts() {
		return invoiceProducts;
	}

	public void setInvoiceProducts(List<InvoiceProduct> invoiceProducts) {
		this.invoiceProducts = invoiceProducts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}

	public void addProduct(Product product) {

		if (products == null) {
			products = new ArrayList<>();
		}

		products.add(product);

		product.setAdmin(this);
	}
	
	public void addVendor(Vendor vendor) {

		if (vendors == null) {
			vendors = new ArrayList<>();
		}

		vendors.add(vendor);

		vendor.setAdmin(this);
	}
	
	public void addPurchaseOrder(PurchaseOrder purchaseOrder) {

		if (purchaseOrders == null) {
			purchaseOrders = new ArrayList<>();
		}

		purchaseOrders.add(purchaseOrder);

		purchaseOrder.setUser(this);
	}
	
	public void addInvoice(Invoice invoice) {

		if (invoices == null) {
			invoices = new ArrayList<>();
		}

		invoices.add(invoice);

		invoice.setUser(this);
	}

}
