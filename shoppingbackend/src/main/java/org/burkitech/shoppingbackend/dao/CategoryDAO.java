package org.burkitech.shoppingbackend.dao;

import java.util.List;
import org.burkitech.shoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);

	List<Category> categoryList();

	Category get(int id);
}
