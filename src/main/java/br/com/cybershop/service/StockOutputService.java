package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.StockOutput;

@Service
public interface StockOutputService {
	List<StockOutput> getAll();
	void save(StockOutput stockOutput);
}
