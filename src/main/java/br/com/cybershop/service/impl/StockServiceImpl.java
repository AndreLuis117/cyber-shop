package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Product;
import br.com.cybershop.model.Stock;
import br.com.cybershop.repository.StockRepository;
import br.com.cybershop.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public List<Stock> getAll() {
		return stockRepository.findAll();
	}

	@Override
	public void save(Stock stock) {
		stockRepository.save(stock);
	}

	@Override
	public Stock getByProduct(Product product) {
		return stockRepository.findByProduct(product);
	}

}
