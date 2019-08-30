package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
	
	Promotion findByPromoName(String name);
}
