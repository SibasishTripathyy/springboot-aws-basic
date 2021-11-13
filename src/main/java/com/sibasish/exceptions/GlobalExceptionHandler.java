package com.sibasish.exceptions;

import com.sibasish.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        Map<String, List<String>> body = new HashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex,
                                                            HandlerMethod handlerMethod,
                                                            HttpServletRequest request) {

        Class controllerClass = handlerMethod.getMethod().getDeclaringClass();
        String methodName = handlerMethod.getMethod().getName();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Timestamp(System.currentTimeMillis()));
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setServicePath(request.getRequestURI());
        errorResponse.setControllerName(controllerClass.toString());
        errorResponse.setMethodName(methodName);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
