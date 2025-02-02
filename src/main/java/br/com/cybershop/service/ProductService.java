package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.Product;


@Service
public interface ProductService {

	List<Product> getAll();
	void save(Product product);
}
