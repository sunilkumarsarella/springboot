package com.spring.demo.exception;

import com.spring.demo.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.ReadOnlyFileSystemException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RequestNotFoundException.class)
    public ResponseEntity<CommonResponse> handleRequestNotFoundException(RequestNotFoundException ex) {
        return ResponseEntity
                .status(404)
                .body(new CommonResponse(false, ex.getMessage(), null, 404));
    }
}
