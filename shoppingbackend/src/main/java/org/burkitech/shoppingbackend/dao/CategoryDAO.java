package org.burkitech.shoppingbackend.dao;

import java.util.List;
import org.burkitech.shoppingbackend.dto.Category;

public interface CategoryDAO {

Category get(int id);
List<Category> categoryList();
	boolean add(Category category);
boolean update(Category category);
boolean delete(Category category);
}
