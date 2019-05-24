package br.com.cybershop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cybershop.model.Client;

@Service
public interface ClientService {
	List<Client> getAll();
}
