package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Catalog;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
	
	Catalog findByName(String name);

}
