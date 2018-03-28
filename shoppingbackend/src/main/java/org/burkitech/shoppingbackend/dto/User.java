package org.burkitech.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAIL")
public class User {
@Id
@Column(name="user_detail_id")
private int id;
@Column(name="first_name")
private String firstName;
@Column(name="last_name")
private String lastName;
private String email;
@Column(name="contact_number")
private String contactNumber;
@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled=" + enabled
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public char getEnabled() {
	return enabled;
}
public void setEnabled(char enabled) {
	this.enabled = enabled;
}
private String role;
private String password;
private char enabled='Y';
}
