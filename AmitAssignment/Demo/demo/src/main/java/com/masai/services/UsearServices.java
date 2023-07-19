package com.masai.services;

import java.util.List;

import com.masai.exception.UsearException;
import com.masai.module.Emails;
import com.masai.module.Usear;

public interface UsearServices {
	
	public Usear registerUsear(Usear usear) throws UsearException;
	
	public List<Emails> getAllEmail() throws UsearException;
	
	public List<Emails> getAllStarredEmail() throws UsearException;
	
	public Usear updateUsear(Usear usear,String email) throws UsearException;
	
}
