package org.burkitech.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ADDRESS_ID")
	private int id;
	// @MapsId("address_id")

	// @JoinColumn(name = "address_id")
	@ManyToOne
	@MapsId("user_detail_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ADDRESS_LINE_ONE")
	private String addressLineOne;
	@Column(name = "ADDRESS_LINE_TWO")
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	@Column(name = "postal_code")
	private String postalCode;
	private char shipping;
	private char billing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public char getBilling() {
		return billing;
	}

	public void setBilling(char billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", billing=" + billing + "]";
	}

	@Column(name = "USER_DETAIL_ID")
	private int userId;

	public char getShipping() {
		return shipping;
	}

	public void setShipping(char shipping) {
		this.shipping = shipping;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
