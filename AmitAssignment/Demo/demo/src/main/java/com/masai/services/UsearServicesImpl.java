package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UsearException;
import com.masai.exception.LoginException;
import com.masai.module.Emails;
import com.masai.module.Usear;
import com.masai.repository.EmailRepo;
import com.masai.repository.UsearRepo;

@Service
public class UsearServicesImpl implements UsearServices{
	@Autowired
	private UsearRepo usearRepo;
	
	@Autowired
	private EmailRepo emailRepo;

	@Override
	public Usear registerUsear(Usear usear) throws UsearException {
		Optional<Usear> opt = usearRepo.findById(usear.getEmail());
		if(opt.isPresent()) {
			throw new UsearException("Usear already exist with this email ");
		}else {
			return usearRepo.save(usear);
		}
	}

	@Override
	public List<Emails> getAllEmail() throws UsearException {
		List<Emails> emails = emailRepo.findAll();
		if(emails.isEmpty()) {
			throw new UsearException("Know email found ");
		}else {
			return emails;
		}
	}

	@Override
	public List<Emails> getAllStarredEmail() throws UsearException {
		List<Emails> emails = emailRepo.findByStarred();
		if(emails.isEmpty()) {
			throw new UsearException("Know email found ");
		}else {
			return emails;
		}
	}

	@Override
	public Usear updateUsear(Usear usear,String email) throws UsearException {
		Optional<Usear> opt = usearRepo.findById(email);
		if(opt.isPresent()) {
			throw new UsearException("Usear Does not  exist with this email ");
		}else {
			usear.setEmail(email);
			return usearRepo.save(usear);
		}
	}

}
