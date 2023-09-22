package com.project.springapistudy.global.error;

import com.project.springapistudy.global.error.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> apiExceptionHandle(ApiException e) {
        log.debug("ApiException", e);
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(convertErrorResponseFrom(e.getErrorCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidHandle(MethodArgumentNotValidException e) {
        log.debug("MethodArgumentNotValidException", e);
        return ResponseEntity.status(CommonErrorCode.INVALID_PARAMETER.getHttpStatus())
                .body(convertErrorResponseFrom(e, CommonErrorCode.INVALID_PARAMETER));
    }

    private ErrorResponse convertErrorResponseFrom(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    private ErrorResponse convertErrorResponseFrom(BindException e, ErrorCode errorCode) {

        List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ErrorResponse.ValidationError::of)
                .collect(Collectors.toList());

        return ErrorResponse.builder()
                .code(errorCode.name())
                .message(errorCode.getMessage())
                .errors(validationErrorList)
                .build();
    }

}
