package com.aka.batchUploading.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface CSVService {


    public void save(MultipartFile file);

    public ByteArrayInputStream load();

    public List<Employee> getAllEmployees();


}
