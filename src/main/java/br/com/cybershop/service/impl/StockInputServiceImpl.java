package br.com.cybershop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Catalog;
import br.com.cybershop.model.Stock;
import br.com.cybershop.model.StockInput;
import br.com.cybershop.repository.CatalogRepository;
import br.com.cybershop.repository.StockInputRepository;
import br.com.cybershop.service.StockInputService;
import br.com.cybershop.service.StockService;

@Service
public class StockInputServiceImpl implements StockInputService {
	@Autowired
	private StockInputRepository repository;
	
	@Autowired
	private StockService stockService;
	
	@Override
	public List<StockInput> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(StockInput data) {
		Stock stock = stockService.getByProduct(data.getProduct());
		if(stock == null) {
			stock = new Stock();
			
			Date date = new Date();
			
			stock.setProduct(data.getProduct());
			stock.setQuantity(data.getQuantity());
			stock.setDateOfLastUpdate();
			
			repository.save(data);
			stockService.save(stock);
		}else {
			long sum = stock.getQuantity() + data.getQuantity();
			stock.setQuantity(sum);
			repository.save(data);
			stockService.save(stock);
		}
	}

}
