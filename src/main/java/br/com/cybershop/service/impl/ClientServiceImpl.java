package br.com.cybershop.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		repository.save(client);
	}

}
