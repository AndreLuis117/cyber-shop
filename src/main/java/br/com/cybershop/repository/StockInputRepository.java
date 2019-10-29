package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Client;
import br.com.cybershop.model.StockInput;

public interface StockInputRepository extends JpaRepository<StockInput, Long>  {

}
