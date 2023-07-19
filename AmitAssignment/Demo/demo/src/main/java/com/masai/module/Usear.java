package com.masai.module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Usear {
	@Id
	@Email(message = "Check the e-mail ID entered and try again ")
	@Column(unique = true)
	private String email;
	
	@Size(min = 2, max = 10, message = "Length of first name should not be more than 2 characters and less than 10 characters")
	private String firstName;
	
	@Size(min = 2, max = 10, message = "Length of last name should not be more than 2 characters and less than 10 characters")
	private String lastName;
	
	@Pattern(regexp = "^[0-9]{10}", message = "Check the mobile number entered and Try again ")
	@Column(unique = true)
	private String MobileNumber;
	
	private LocalDate dateOfBirth;
	
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]$",message = "Password should contain at least 1 uppercase character, 1 lower case character, 1 special character, numeric value and length of the password should be more than 8 characters ")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String Password;
	
    @ManyToMany(cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Emails> emails;
}

