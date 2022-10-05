package com.hkemal.java.dataStructures;

import java.lang.reflect.Method;
import java.util.Arrays;

public class B1_JavaGenerics {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] strings = {"Hello", "World"};
        Integer[] numbers = {1, 2, 3};
        ArrayPrinter.print(numbers);
        ArrayPrinter.print(strings);

        Class cls = Class.forName("com.hkemal.java.dataStructures.ArrayPrinter");
        Method methlist[] = cls.getDeclaredMethods();
        long printMethodCount = Arrays.stream(methlist).filter(item -> item.getName().equals("print")).count();
        if (printMethodCount > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}

class ArrayPrinter {
    public static <T> void print(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}
