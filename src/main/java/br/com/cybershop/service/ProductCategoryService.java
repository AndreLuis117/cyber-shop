package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.ProductCategory;
@Service
public interface ProductCategoryService {
	
	List<ProductCategory> getAll();
	void save(ProductCategory productCategory);
	void delete(ProductCategory productCategory);
}
