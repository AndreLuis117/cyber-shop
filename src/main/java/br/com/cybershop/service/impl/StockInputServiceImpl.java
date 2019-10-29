package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Catalog;
import br.com.cybershop.model.StockInput;
import br.com.cybershop.repository.CatalogRepository;
import br.com.cybershop.repository.StockInputRepository;
import br.com.cybershop.service.StockInputService;

@Service
public class StockInputServiceImpl implements StockInputService {
	@Autowired
	private StockInputRepository repository;
	
	@Override
	public List<StockInput> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(StockInput stockInput) {
		repository.save(stockInput);
	}

}
