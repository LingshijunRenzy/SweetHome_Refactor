package org.tomjerry.sweethome.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.tomjerry.sweethome.vo.response.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleRuntimeException(RuntimeException e) {
        return new Result<>(400, e.getMessage(), null);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new Result<>(400, e.getMessage(), null);
    }



    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> handleMissingPathVariableException(MissingPathVariableException e) {
        return new Result<>(400, e.getMessage(), null);
    }
}