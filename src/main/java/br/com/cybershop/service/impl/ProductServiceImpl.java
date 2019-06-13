package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Client;
import br.com.cybershop.model.Product;
import br.com.cybershop.repository.ClientRepository;
import br.com.cybershop.repository.ProductRepository;
import br.com.cybershop.service.ClientService;
import br.com.cybershop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		repository.save(product);
	}
}
