package org.burkitech.shoppingbackend.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Employee{

	@Id
	@Column(name = "employee_id")
	private int id;
	
	@NotBlank(message = "Please enter the Product Name!")
	private String name;
	
	@NotBlank(message = "Please enter the Date!")
	private Date jdate;
	
	@NotBlank(message = "Please enter the route!")
	private String route;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return jdate;
	}
	public void setDate(Date date) {
		this.jdate = date;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", date=" + jdate + ", route=" + route + ", city=" + city + "]";
	}
	
	
}
