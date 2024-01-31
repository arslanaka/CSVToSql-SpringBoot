package com.aka.batchUploading;
import com.aka.batchUploading.entity.CsvEntity;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
    public List<CsvEntity> readCsv(String filePath) throws IOException {
        List<CsvEntity> entities = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] headers = reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                Map<String, String> entityProperties = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    entityProperties.put(headers[i], line[i]);
                }
                CsvEntity entity = new CsvEntity(entityProperties);
                entities.add(entity);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return entities;
    }
}

