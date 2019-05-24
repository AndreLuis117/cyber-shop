package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cybershop.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Client findByName(String name);

}
