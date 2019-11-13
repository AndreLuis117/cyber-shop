package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.StockOutput;

public interface StockOutputRepository extends JpaRepository<StockOutput, Long> {

}
