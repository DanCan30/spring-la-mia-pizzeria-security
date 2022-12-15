package org.generation.italy.main.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.generation.italy.main.pojo.Role;
import org.generation.italy.main.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DBUserDetails implements UserDetails {

	private static final long serialVersionUID = 5931684329116442440L;

	private final User user;
	
	public DBUserDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<Role> userRoles = this.user.getRoles();
		Set<GrantedAuthority> grantRole = new HashSet<>();
		for (Role role : userRoles) {
			grantRole.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return grantRole;
		
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
