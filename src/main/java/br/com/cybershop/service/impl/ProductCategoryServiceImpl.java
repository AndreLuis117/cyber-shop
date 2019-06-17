package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.ProductCategory;
import br.com.cybershop.repository.ProductCategoryRepository;
import br.com.cybershop.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository repository;
	
	@Override
	public List<ProductCategory> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		repository.save(productCategory);
	}

}
