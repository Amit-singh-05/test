package com.prospecta.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.dto.AllEntriesDTO;
import com.prospecta.dto.EntriesDTO;
import com.prospecta.dto.EntryDTO;
import com.prospecta.exception.EntryException;
import com.prospecta.model.Entries;
import com.prospecta.repository.EntryRepo;

@Service
public class EntryServicesImpl implements EntryServices{
	@Autowired
	private EntryRepo entryRepo;
	
	
	@Override
	public List<EntryDTO> getDataByCategory(String category) throws EntryException {
        //url to be used => https://api.publicapis.org/entries
		RestTemplate restTemp = new RestTemplate();
		AllEntriesDTO entries = restTemp.getForObject("https://api.publicapis.org/entries", AllEntriesDTO.class);
		
		System.out.println(entries);
		
		List<EntryDTO> entryList = entries.getEntries().stream()
		        .filter(e -> category.equals(e.getCategory()))
		        .map(e -> new EntryDTO(e.getAPI(), e.getDescription()))
		        .collect(Collectors.toList());
		
		if(entryList.size() == 0) {
			throw new EntryException("No entry found for category => " + category);
		}
		
		return entryList;
	}


	@Override
	public Entries saveNewEntry(Entries entries) throws EntryException {
		RestTemplate restTemp = new RestTemplate();
		AllEntriesDTO ent = restTemp.getForObject("https://api.publicapis.org/entries", AllEntriesDTO.class);
		
		Optional<Entries> edt = entryRepo.findById(entries.getLink());
		List<EntriesDTO>edt2 = ent.getEntries().stream()
		        .filter(e -> entries.getLink().equals(e.getLink())).collect(Collectors.toList());
		if(edt.isPresent()&& !edt2.isEmpty()) {
			throw new EntryException("Entry already present with this link => " + entries.getLink());
		}else {
			return entryRepo.save(entries);
		}
	}

}
