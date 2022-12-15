package org.generation.italy.main.repo;

import java.util.Optional;

import org.generation.italy.main.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUsername(String username);
	
}
