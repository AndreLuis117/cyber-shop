package br.com.cybershop.service;

import java.util.List;

import br.com.cybershop.model.Product;
import br.com.cybershop.model.ProductCategory;

public interface ProductCategoryService {
	
	List<ProductCategory> getAll();
	void save(ProductCategory productCategory);

}
