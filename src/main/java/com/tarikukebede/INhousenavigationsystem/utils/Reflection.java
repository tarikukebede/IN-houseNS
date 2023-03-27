package com.tarikukebede.INhousenavigationsystem.utils;

public class Reflection {
    public static<T> String getClassName(T obj){
        return obj.getClass().getSimpleName();
    }
}
