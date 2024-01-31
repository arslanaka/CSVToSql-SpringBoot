package com.aka.batchUploading.entity;

import java.util.Map;

public class CsvEntity {
    private Map<String, String> properties;

    public CsvEntity(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    // Other methods as needed
}
