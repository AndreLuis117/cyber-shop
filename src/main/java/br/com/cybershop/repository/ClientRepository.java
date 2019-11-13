package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cybershop.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Client findByName(String name);
	Client findByUserUsername(String username);
	
	/*
	@Query("Select c from Client c where c.user.username = :username")
	Client findlalal(String username); */

}
