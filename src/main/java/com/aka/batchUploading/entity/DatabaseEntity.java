package com.aka.batchUploading.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Map;

@Entity
public class DatabaseEntity {
    @Id
    private Long id;

    // Use a Map for dynamic columns
    private Map<String, String> dynamicColumns;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getDynamicColumns() {
        return dynamicColumns;
    }

    public void setDynamicColumns(Map<String, String> dynamicColumns) {
        this.dynamicColumns = dynamicColumns;
    }
}