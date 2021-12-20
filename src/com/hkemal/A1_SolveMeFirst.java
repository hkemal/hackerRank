package com.hkemal;

import java.util.Scanner;

public class A1_SolveMeFirst {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }

    static int solveMeFirst(int a, int b) {
        return a + b;
    }
}

