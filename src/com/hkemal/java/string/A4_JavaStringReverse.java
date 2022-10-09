package com.hkemal.java.string;

import java.util.Scanner;

public class A4_JavaStringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        StringBuilder reverseStringBuilder = new StringBuilder();
        char[] chars = A.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseStringBuilder.append(chars[i]);
        }
        System.out.println(A.equals(reverseStringBuilder.toString()) ? "Yes" : "No");
    }
}
