package com.prospecta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntriesDTO{
	private String API;
	private String Description;
	private String Auth;
	private boolean HTTPS;
	private String Cors;
	private String Link;
	private String Category;
}