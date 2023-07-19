package com.masai.services;

import com.masai.exception.EmailException;
import com.masai.module.Emails;

public interface EmailServices {
	
	public Emails sendEmail(Emails email) throws EmailException;
	
	public Emails starEmail(Integer email_id) throws EmailException;
	
	public Emails deleteEmail(Integer email_id) throws EmailException;
}
