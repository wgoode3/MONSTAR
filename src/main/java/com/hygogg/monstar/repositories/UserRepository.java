package com.hygogg.monstar.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hygogg.monstar.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
}
