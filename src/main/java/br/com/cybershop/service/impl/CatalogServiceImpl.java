package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Catalog;
import br.com.cybershop.repository.CatalogRepository;
import br.com.cybershop.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogRepository repository;
	
	@Override
	public List<Catalog> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Catalog catalog) {
		repository.save(catalog);
	}

	@Override
	public void delete(Catalog catalog) {
			repository.delete(catalog);
	}

}
