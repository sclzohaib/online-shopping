package org.burkitech.shoppingbackend.dao;

import org.burkitech.shoppingbackend.dto.Employee;

public interface EmployeeDAO {
	Employee get(int id);
	boolean add(Employee employee);
boolean update(Employee employee);
boolean delete(Employee employee);
}
