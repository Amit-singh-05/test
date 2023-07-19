package com.masai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmailException;
import com.masai.exception.UsearException;
import com.masai.module.Emails;
import com.masai.module.Usear;
import com.masai.repository.UsearRepo;
import com.masai.services.UsearServices;

@RestController
@RequestMapping("/usearController")
public class UsearController {
	@Autowired
	private UsearServices usearServices;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsearRepo usearRepo;

	
	@PostMapping("/registerUsear")
	public ResponseEntity<Usear> registerUsearHandler(@Valid @RequestBody Usear usear) throws UsearException {
		
		usear.setPassword(passwordEncoder.encode(usear.getPassword()));
		
		Usear savedUser = usearServices.registerUsear(usear);

		return new ResponseEntity<Usear>(savedUser, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUsear(){
		String str = "User logged in successfully ";
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	@PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:logout";
    }
	
}
