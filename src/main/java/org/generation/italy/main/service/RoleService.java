package org.generation.italy.main.service;

import org.generation.italy.main.pojo.Role;
import org.generation.italy.main.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	public void save(Role role) {
		roleRepo.save(role);
	}
	
	public void delete(Role role) {
		roleRepo.delete(role);
	}
}
