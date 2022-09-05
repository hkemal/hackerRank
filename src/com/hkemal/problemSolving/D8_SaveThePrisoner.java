package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class D8_SaveThePrisoner {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            int s = Integer.parseInt(firstMultipleInput[2]);
            int result = ResultSaveThePrisoner.saveThePrisoner(n, m, s);
            System.out.println(result);
        });
    }
}

class ResultSaveThePrisoner {
    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */
    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        if ((s + m - 1) % n == 0) return n;
        return (s + m - 1) % n;
    }
}



