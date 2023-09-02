package com.aka.batchUploading.service.impl;

import com.aka.batchUploading.entity.Employee;
import com.aka.batchUploading.repository.EmployeeRepository;
import com.aka.batchUploading.service.CSVService;
import com.aka.batchUploading.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


@Service
public class CSVServiceImpl implements CSVService {


    @Autowired
    EmployeeRepository repository;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Employee> employees = CSVHelper.csvToEmployees(file.getInputStream());
            repository.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    @Override
    public ByteArrayInputStream load() {
        List<Employee> employees = repository.findAll();
        return CSVHelper.employeesToCSV(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}
