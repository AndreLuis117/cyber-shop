package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Product;
import br.com.cybershop.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	Stock findByProduct(Product product);
}
