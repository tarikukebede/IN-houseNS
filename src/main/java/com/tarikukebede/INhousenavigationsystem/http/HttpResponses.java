package com.tarikukebede.INhousenavigationsystem.http;

import com.tarikukebede.INhousenavigationsystem.utils.Reflection;

public class HttpResponses {
    private static final String NOT_FOUND = "Sorry! There is no entity matching the given Id of ${id}";
    private static final String INTERNAL_ERROR = "Ops! we encountered a problem while processing entity.";
    private static final String BAD_REQUEST = "Bad request! error occurred while processing entity";
    private static final String NOT_DETECTED = "Unable to determine location of mobile station with id ${id}";

    public static <T, K> String notFoundResponse(T obj, K k) {
        return NOT_FOUND.replace("entity", Reflection.getClassName(obj)).replace("${id}", String.valueOf(k));
    }

    public static <T> String errorWhileProcessing(T obj) {
        return INTERNAL_ERROR.replace("entity", Reflection.getClassName(obj));
    }

    public static <T> String badRequest(T obj) {
        return BAD_REQUEST.replace("entity", Reflection.getClassName(obj));
    }

    public static <K> String notDetected(K k) {
        return NOT_DETECTED.replace("${id}", String.valueOf(k));
    }

}
