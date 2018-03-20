package org.burkitech.shoppingbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.burkitech.shoppingbackend.dto.Category;
import org.burkitech.shoppingbackend.dto.Product;

public interface ProductDAO {
	
Product get(int id);
List<Product> productList();
	boolean add(Product product);
boolean update(Product product);
boolean delete(Product product);

//bussiness methods
List<Product> listActiveProducts();
List<Product> listActiveProductsByCategory(int categoryId);
List<Product> getLatestActiveProducts(int count);
}
