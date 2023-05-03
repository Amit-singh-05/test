package com.prospecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.dto.EntryDTO;
import com.prospecta.exception.EntryException;
import com.prospecta.model.Entries;
import com.prospecta.services.EntryServices;

@RestController
@RequestMapping("/entryController")
public class EntryController {
	
	@Autowired
	private EntryServices entryServices;
	
	@GetMapping("/getDataByCategory")
	public ResponseEntity<List<EntryDTO>> getDataByCategoryHandler(@RequestParam("category") String category) throws EntryException{
//		System.out.println(category);
		
		List<EntryDTO> admin = entryServices.getDataByCategory(category);

		return new ResponseEntity<List<EntryDTO>>(admin, HttpStatus.OK);

	}
	
//	@PostMapping("/saveNewEntry")
//	public ResponseEntity<Entries> saveNewEntryHandler(@RequestBody Entries entries) throws EntryException{
//		
//		Entries savedEntry = entryServices.saveNewEntry(entries);
//
//		return new ResponseEntity<Entries>(savedEntry, HttpStatus.OK);
//	}
	
}