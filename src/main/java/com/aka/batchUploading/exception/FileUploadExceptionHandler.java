package com.aka.batchUploading.exception;

import com.aka.batchUploading.utils.CustomResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



//Here we are using @ControllerAdvice annotation to define global exception handling. It helps us from code duplication
@ControllerAdvice
public class FileUploadExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<CustomResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new CustomResponseMessage("File too large!"));
    }
}
