package br.com.cybershop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.Client;

@Service
public interface ClientService {
	List<Client> getAll();
	void save(Client client);
	void delete(Client client);
	Optional<Client> findById(long id);
}

