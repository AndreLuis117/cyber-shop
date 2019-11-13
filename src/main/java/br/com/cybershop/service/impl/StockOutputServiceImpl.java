package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Stock;
import br.com.cybershop.model.StockOutput;
import br.com.cybershop.repository.StockOutputRepository;
import br.com.cybershop.service.StockOutputService;
import br.com.cybershop.service.StockService;

@Service
public class StockOutputServiceImpl implements StockOutputService {

	@Autowired
	private StockOutputRepository repository;
	
	@Autowired
	private StockService stockService;
	@Override
	public List<StockOutput> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(StockOutput stockOutput) {
		if(validateMinimunStock(stockOutput)) {
			repository.save(stockOutput);
			Stock stock = stockService.getByProduct(stockOutput.getProduct());
			long quantityUpdated = stock.getQuantity() - stockOutput.getQuantity();
			stock.setQuantity(quantityUpdated);
			stockService.save(stock);
		}
		
	}
	
	
	public boolean validateMinimunStock(StockOutput stockOutput) {
		Stock stock = stockService.getByProduct(stockOutput.getProduct());
		if(stock == null) {
			return false;
		}
		long sum = stock.getQuantity() - stockOutput.getQuantity();
		if(sum < 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
