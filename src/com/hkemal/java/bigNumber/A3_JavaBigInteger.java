package com.hkemal.java.bigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class A3_JavaBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1 = sc.nextLine();
        BigInteger bigInteger1 = new BigInteger(number1);
        String number2 = sc.nextLine();
        BigInteger bigInteger2 = new BigInteger(number2);
        System.out.println(bigInteger1.add(bigInteger2));
        System.out.println(bigInteger1.multiply(bigInteger2));
    }
}
