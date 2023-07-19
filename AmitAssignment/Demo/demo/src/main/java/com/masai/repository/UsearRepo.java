package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.module.Usear;

@Repository
public interface UsearRepo extends JpaRepository<Usear, String>{
	public Optional<Usear> findByEmail(String email);

}
