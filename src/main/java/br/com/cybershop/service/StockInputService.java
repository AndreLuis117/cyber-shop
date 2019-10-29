package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.StockInput;

@Service
public interface StockInputService {
	List<StockInput> getAll();
	void save(StockInput promotion);
}
