package com.ninjaone.rmmbackend.model.util;

import lombok.experimental.UtilityClass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@UtilityClass
public class Generics {

    public static Class getFirstGenericType(Class<?> clazz) {
        return (Class) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static Class getFirstGenericInterfaceType(Class<?> clazz) {
        ParameterizedType parameterizedType = (ParameterizedType) ((Class) clazz.getGenericInterfaces()[0]).getGenericInterfaces()[0];
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        Class<?> typeArgument = (Class<?>) typeArguments[0];
        return typeArgument;
    }

}
