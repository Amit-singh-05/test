package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.module.Emails;

public interface EmailRepo extends JpaRepository<Emails, Integer>{
	
	@Query("from Emails where starred=true")
	public List<Emails> findByStarred();

}
