package org.generation.italy.main.service;

import java.util.Optional;

import org.generation.italy.main.pojo.User;
import org.generation.italy.main.repo.UserRepo;
import org.generation.italy.main.security.DBUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	public void save(User user) {
		userRepo.save(user);
	}
	
	public void delete(User user) {
		userRepo.delete(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userOpt = userRepo.findByUsername(username);
		if(userOpt.isEmpty() ) throw new UsernameNotFoundException("User not found.");
		
		return new DBUserDetails(userOpt.get());
	}
}
