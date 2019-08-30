package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.Catalog;

@Service
public interface CatalogService {
	List<Catalog> getAll();
	void save(Catalog catalog);
	void delete(Catalog catalog);
}
