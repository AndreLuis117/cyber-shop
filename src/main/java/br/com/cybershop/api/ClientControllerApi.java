package br.com.cybershop.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cybershop.model.Client;
import br.com.cybershop.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientControllerApi {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping()
	public ResponseEntity<List<Client>> getAll(){
		return new ResponseEntity(clientService.getAll(),HttpStatus.OK);
	}
	
	
	public ResponseEntity<?> save(@RequestBody @Valid Client client){
		clientService.save(client);
		return new ResponseEntity(clientService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @Valid @RequestBody Client client){
		Optional<Client> maybeClient = clientService.findById(id);
				if(!maybeClient.isPresent()) {
					return ResponseEntity.notFound().build();
				}
		Client oldClient = maybeClient.get();
		oldClient.setName(client.getName());
		//Fazer todos os atributos
		return new ResponseEntity(clientService.getAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Optional<Client> maybeClient = clientService.findById(id);
				if(!maybeClient.isPresent()) {
					return ResponseEntity.notFound().build();
				}
		clientService.delete(maybeClient.get());
		return new ResponseEntity(clientService.getAll(),HttpStatus.OK);
	}
}
