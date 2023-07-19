package com.masai.module;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Emails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer email_id;
	
	@Email(message = "Check the sender e-mail ID entered and try again ")
	private String senderEmailIdEmail;
	
	@Email(message = "Check the receivers e-mail ID entered and try again ")
	private String receiversEmailIdEmail;
	
	@Size(min = 0, max = 80, message = "Length of subject should not be more than 80 characters and less than 0 characters")
	private String subject;
	
	private String emailBody;
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean starred;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "emails")
	@JsonIgnore
	private List<Usear> usears = new ArrayList<>();
}
