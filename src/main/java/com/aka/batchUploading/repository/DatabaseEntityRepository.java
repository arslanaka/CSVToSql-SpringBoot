package com.aka.batchUploading.repository;

import com.aka.batchUploading.entity.DatabaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface DatabaseEntityRepository extends CrudRepository<DatabaseEntity, Long> {
    // Custom queries if needed
}
