package com.prospecta.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEntriesDTO{
    private Integer count;
	private List<EntriesDTO> entries;
}