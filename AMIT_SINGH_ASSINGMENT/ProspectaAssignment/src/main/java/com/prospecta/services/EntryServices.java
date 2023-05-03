package com.prospecta.services;

import java.util.List;

import com.prospecta.dto.EntryDTO;
import com.prospecta.exception.EntryException;
import com.prospecta.model.Entries;

public interface EntryServices {
	
	public List<EntryDTO> getDataByCategory(String category) throws EntryException;
	
//	public Entries saveNewEntry(Entries entries) throws EntryException;
}
