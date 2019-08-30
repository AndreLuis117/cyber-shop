package br.com.cybershop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Promotion;
import br.com.cybershop.repository.PromotionRepository;
import br.com.cybershop.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private PromotionRepository repository;
	
	@Override
	public List<Promotion> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Promotion promotion) {
		repository.save(promotion);
	}


}
