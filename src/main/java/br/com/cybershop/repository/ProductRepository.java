package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);
}
