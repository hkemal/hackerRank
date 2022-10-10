package com.hkemal.java.exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A1_JavaTryCatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int number1 = input.nextInt();
            int number2 = input.nextInt();
            System.out.println(number1 / number2);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(inputMismatchException.getClass().getName());
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.toString());
        }
    }

}


