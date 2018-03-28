package org.burkitech.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
@Id
@Column(name="address_id")
private int id;
@Column(name="user_detail_id")
private int userId;
@Override
public String toString() {
	return "Address [id=" + id + ", userId=" + userId + ", addressLineOne=" + addressLineOne + ", addressLinetwo="
			+ addressLinetwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode="
			+ postalCode + ", shipping=" + shipping + ", billing=" + billing + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getAddressLineOne() {
	return addressLineOne;
}
public void setAddressLineOne(String addressLineOne) {
	this.addressLineOne = addressLineOne;
}
public String getAddressLinetwo() {
	return addressLinetwo;
}
public void setAddressLinetwo(String addressLinetwo) {
	this.addressLinetwo = addressLinetwo;
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
public char getShipping() {
	return shipping;
}
public void setShipping(char shipping) {
	this.shipping = shipping;
}
public char getBilling() {
	return billing;
}
public void setBilling(char billing) {
	this.billing = billing;
}
@Column(name="address_line_one")
private String addressLineOne;
@Column(name="address_line_two")
private String addressLinetwo;
private String city;
private String state;
private String country;
@Column(name="postal_code")
private String postalCode;
private char shipping;
private char billing;

}
