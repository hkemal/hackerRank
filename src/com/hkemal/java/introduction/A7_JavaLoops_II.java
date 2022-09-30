package com.hkemal.java.introduction;

import java.util.Scanner;

public class A7_JavaLoops_II {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int n = input.nextInt();
            for (int j = 0; j < n; j++) {
                double multiple = Math.pow(2, j);
                int res = (int) (b * multiple);
                a = a + res;
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
