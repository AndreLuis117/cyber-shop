package br.com.cybershop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import br.com.cybershop.model.User;
import br.com.cybershop.repository.UserRepository;
import br.com.cybershop.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
