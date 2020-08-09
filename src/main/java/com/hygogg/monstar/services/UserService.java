package com.hygogg.monstar.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hygogg.monstar.models.User;
import com.hygogg.monstar.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
    
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    // create and return the user for register
    public User registerUser(User user) {
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hash);
        return userRepo.save(user);
    }
	
    // find a user based on email, useful for login
    public User findByEmail(String email) {
    	Optional<User> user = userRepo.findByEmail(email);
    	return user.isPresent() ? user.get() : null;
    }
    
    // return a user based on id, useful with session
    public User findById(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	return user.isPresent() ? user.get() : null;
    }
    
    // return an instance of User if successful login
    // otherwise return null
    public User login(String email, String password) {
    	User user = findByEmail(email);
    	if(user != null && BCrypt.checkpw(password, user.getPassword())) {
    		return user;
    	}
    	return null;
    }
    
}
