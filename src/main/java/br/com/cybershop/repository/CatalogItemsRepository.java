package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.CatalogItems;

public interface CatalogItemsRepository extends JpaRepository<CatalogItems, Long>{
	

}
