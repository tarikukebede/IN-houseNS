package com.tarikukebede.INhousenavigationsystem.http;

import com.tarikukebede.INhousenavigationsystem.utils.Reflection;

public class HttpResponses {
    public static final String NOT_FOUND = "Sorry! There is no entity matching the given Id of ${id}";
    public static final String INTERNAL_ERROR = "Ops! we encountered a problem while processing entity.";
    public static final String BAD_REQUEST = "Bad request! error occurred while processing entity";

    public static <T,K> String notFoundResponse(T obj, K k){
        return NOT_FOUND.replace("entity", Reflection.getClassName(obj)).replace("${id}", String.valueOf(k));
    }

    public static <T> String errorWhileProcessing(T obj){
        return INTERNAL_ERROR.replace("entity", Reflection.getClassName(obj));
    }

    public static <T> String badRequest(T obj){
        return BAD_REQUEST.replace("entity", Reflection.getClassName(obj));
    }
}
