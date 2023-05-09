package com.tarikukebede.INhousenavigationsystem.interfaces;

import org.springframework.web.server.ResponseStatusException;

public interface IErrorHandler<T, K> {
    ResponseStatusException notFound(T t, K k);
    ResponseStatusException errorWileProcessing(T t);
    ResponseStatusException badRequest(T t);
    ResponseStatusException notDetected(K k);
}
