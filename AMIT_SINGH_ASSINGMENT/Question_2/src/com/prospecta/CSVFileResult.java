package com.prospecta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVFileResult {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String csvfile = "input.csv";
        String result;
        
        Map<String, String> cells = new HashMap();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String cell = data[0];
                String value = data[1];
                cells.put(cell, value);
            }
        }

	}

}
