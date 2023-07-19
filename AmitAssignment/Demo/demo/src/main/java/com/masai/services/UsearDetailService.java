package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.module.Usear;
import com.masai.module.UsearLogin;
import com.masai.repository.UsearRepo;

@Service
public class UsearDetailService implements UserDetailsService{
	
	@Autowired
	private UsearRepo usearRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usear> opt = usearRepo.findByEmail(email);
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException("No usear detail found with this email ");
		}else {
			return new UsearLogin(opt.get());
		}
	}

}
