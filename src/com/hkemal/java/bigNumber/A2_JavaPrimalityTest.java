package com.hkemal.java.bigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class A2_JavaPrimalityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        BigInteger bigInteger = new BigInteger(n);
        boolean probablePrime = bigInteger.isProbablePrime(1);
        System.out.println(probablePrime ? "prime" : "not prime");
    }
}
