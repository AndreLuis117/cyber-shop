package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.Promotion;

@Service
public interface PromotionService {
	
	List<Promotion> getAll();
	void save(Promotion promotion);

}
