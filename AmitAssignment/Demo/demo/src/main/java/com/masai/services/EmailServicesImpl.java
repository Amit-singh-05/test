package com.masai.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.masai.exception.EmailException;
import com.masai.module.Emails;
import com.masai.module.Usear;
import com.masai.module.UsearLogin;
import com.masai.repository.EmailRepo;
import com.masai.repository.UsearRepo;

@Service
public class EmailServicesImpl implements EmailServices{
	@Autowired
	private UsearRepo usearRepo;
	
	@Autowired
	private EmailRepo emailRepo;
	
	@Override
	public Emails sendEmail(Emails email) throws EmailException {
		Optional<Emails> eopt = emailRepo.findById(email.getEmail_id());
		if(eopt.isPresent()) {
			throw new EmailException("Email already exist with this email ID -> "+email.getEmail_id());
		}else {
			Optional<Usear> su = usearRepo.findByEmail(email.getSenderEmailIdEmail());
			Optional<Usear> ru = usearRepo.findByEmail(email.getSenderEmailIdEmail());
			if(su.isEmpty()) {
				throw new EmailException("Entered senders email ID is invalid ");
			}else if(ru.isEmpty()){
				throw new EmailException("Entered receivers email ID is invalid ");
			}else {
				email.getUsears().add(su.get());
				if(su.get().getEmails()==null) {
					su.get().setEmails(new ArrayList<>());
					su.get().getEmails().add(email);
					usearRepo.save(su.get());
				}
				email.setStarred(false);
				return emailRepo.save(email);
			}
			
		}
	}

	@Override
	public Emails starEmail(Integer email_id) throws EmailException {
		Optional<Emails> eopt = emailRepo.findById(email_id);
		if(eopt.isEmpty()) {
			throw new EmailException("Email Does not exist with this email ID -> "+email_id);
		}else {
			eopt.get().setStarred(true);
			return emailRepo.save(eopt.get());
		}
	}

	@Override
	public Emails deleteEmail(Integer email_id) throws EmailException {
		Optional<Emails> eopt = emailRepo.findById(email_id);
		if(eopt.isEmpty()) {
			throw new EmailException("Email Does not exist with this email ID -> "+email_id);
		}else {
			eopt.get().setStarred(true);
			emailRepo.delete(eopt.get());
			return eopt.get();
		}
	}

}
