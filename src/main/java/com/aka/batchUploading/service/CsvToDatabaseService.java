package com.aka.batchUploading.service;

import com.aka.batchUploading.CsvReader;
import com.aka.batchUploading.entity.CsvEntity;
import com.aka.batchUploading.entity.DatabaseEntity;
import com.aka.batchUploading.repository.DatabaseEntityRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CsvToDatabaseService {
    private final CsvReader csvReader;
    private final DatabaseEntityRepository repository;

    public CsvToDatabaseService(CsvReader csvReader, DatabaseEntityRepository repository) {
        this.csvReader = csvReader;
        this.repository = repository;
    }

    public void processCsv(String filePath) throws IOException {
        List<CsvEntity> csvEntities = csvReader.readCsv(filePath);

        for (CsvEntity csvEntity : csvEntities) {
            DatabaseEntity databaseEntity = convertToDatabaseEntity(csvEntity);
            repository.save(databaseEntity);
        }
    }

    private DatabaseEntity convertToDatabaseEntity(CsvEntity csvEntity) {
        DatabaseEntity databaseEntity = new DatabaseEntity();
        databaseEntity.setDynamicColumns(csvEntity.getProperties());
        return databaseEntity;
    }
}
