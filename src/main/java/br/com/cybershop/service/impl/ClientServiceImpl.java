package br.com.cybershop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cybershop.model.Client;
import br.com.cybershop.repository.ClientRepository;
import br.com.cybershop.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Override
	public List<Client> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Client client) {
		repository.save(client);
	}

	@Override
	public void delete(Client client) {
			repository.delete(client);
	}

	@Override
	public Optional<Client> findById(long id) {
		return repository.findById(id);
	}

}
