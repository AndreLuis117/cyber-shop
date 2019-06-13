package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	
	ProductCategory findByName(String name);


}
