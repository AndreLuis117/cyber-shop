package br.com.cybershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cybershop.model.User;


@Repository
public interface UserRepository extends  JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
