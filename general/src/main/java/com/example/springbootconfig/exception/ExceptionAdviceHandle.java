package com.example.springbootconfig.exception;

import com.example.springbootconfig.context.VarContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionAdviceHandle extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(GeneralException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage generalException(GeneralException ex){
        String errorCode = ex.getCode();
        String message = messageSource.getMessage(errorCode, null, new Locale(VarContext.getLang()));
        return new ErrorMessage(errorCode,message);
    }

}
