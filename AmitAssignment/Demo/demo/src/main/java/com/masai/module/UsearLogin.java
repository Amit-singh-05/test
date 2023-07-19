package com.masai.module;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsearLogin implements UserDetails{
	
    @Autowired
	private Usear usear;
	
	public UsearLogin(Usear usearfromDatabase) {
		this.usear = usearfromDatabase;
	}
	public Usear getUsear() {
		return usear;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_usear");
		authorities.add(role);
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usear.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usear.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
