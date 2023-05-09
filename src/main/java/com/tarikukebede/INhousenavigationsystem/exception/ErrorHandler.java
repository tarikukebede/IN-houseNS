package com.tarikukebede.INhousenavigationsystem.exception;

import com.tarikukebede.INhousenavigationsystem.http.HttpResponses;
import com.tarikukebede.INhousenavigationsystem.interfaces.IErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorHandler<T, K> implements IErrorHandler<T, K> {
    protected T t;

    public ErrorHandler(T t) {
        this.t = t;
    }
    @Override
    public ResponseStatusException notFound(T t, K id) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                HttpResponses.notFoundResponse(t, id));
    }
    @Override
    public ResponseStatusException errorWileProcessing(T t) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                HttpResponses.errorWhileProcessing(t));
    }
    @Override
    public ResponseStatusException badRequest(T t) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                HttpResponses.badRequest(t));
    }
    @Override
    public ResponseStatusException notDetected(K k) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                HttpResponses.notDetected(k));
    }
}
