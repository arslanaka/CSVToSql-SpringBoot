package com.aka.batchUploading.controller;

import com.aka.batchUploading.service.CsvToDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/csv-to-database")
public class CsvToDatabaseController {
    private final CsvToDatabaseService csvToDatabaseService;

    @Autowired
    public CsvToDatabaseController(CsvToDatabaseService csvToDatabaseService) {
        this.csvToDatabaseService = csvToDatabaseService;
    }

    @PostMapping("/process")
    public void processCsv(@RequestParam String filePath) throws IOException {
        csvToDatabaseService.processCsv(filePath);
    }
}