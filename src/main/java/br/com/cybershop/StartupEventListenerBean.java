package br.com.cybershop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.cybershop.model.User;
import br.com.cybershop.repository.UserRepository;


@Component
public class StartupEventListenerBean {
@Autowired
private UserRepository userRepository;

@EventListener
public void onApplicationEvent(ContextRefreshedEvent event) {
	if(userRepository.findByUsername("user") == null) {
	User user = new User();
	user.setUsername("user");
	user.setPassword("user");
	user.setRole("ROLE_USER");
	userRepository.save(user);
	}
	
	}
}
