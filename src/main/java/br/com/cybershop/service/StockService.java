package br.com.cybershop.service;

import java.util.List;

import br.com.cybershop.model.Product;
import br.com.cybershop.model.Stock;

public interface StockService {
	List<Stock> getAll();
	void save(Stock stock);
	Stock getByProduct(Product product);
}
