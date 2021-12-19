package com.hkemal;

import java.util.Scanner;
import java.util.stream.IntStream;

public class A7_Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ResultStaircase.staircase(n);
    }
}

class ResultStaircase {
    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void staircase(int n) {
        // Write your code here
        IntStream.range(0, n).forEach(i -> {
            IntStream.range(0, n - i - 1).forEach(j -> {
                System.out.print(" ");
            });
            IntStream.range(0, i + 1).forEach(j -> {
                System.out.print("#");
            });
            System.out.println();
        });
    }
}

