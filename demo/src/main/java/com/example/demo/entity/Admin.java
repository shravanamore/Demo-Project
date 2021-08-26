package com.example.demo.entity;

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
@Table(name = "admin")
public class Admin {

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

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Vendor> vendors;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<Product> products;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<User> users;
	
	public Admin() {

	}

	public Admin(String userName, String firstName, String lastName, String password) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {

		if (users == null) {
			users = new ArrayList<>();
		}

		users.add(user);

		user.setAdmin(this);
	}
	
	public void addProduct(Product product) {

		if (products == null) {
			products = new ArrayList<>();
		}

		products.add(product);

		product.setAdmin(this);
	}
	
	public void add(Vendor vendor) {

		if (vendors == null) {
			vendors = new ArrayList<>();
		}

		vendors.add(vendor);

		vendor.setAdmin(this);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + "]";
	}	

}
