package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class C4_DrawingBook {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        int p = Integer.parseInt(in.nextLine().trim());
        int result = ResultDrawingBook.pageCount(n, p);
        System.out.println(result);
    }
}

class ResultDrawingBook {
    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */
    public static int pageCount(int n, int p) {
        // Write your code here
        Integer initiallyPageCount = 0;
        Integer lastlyPageCount = 0;
        IntPredicate isEven = argument -> argument % 2 == 0;
        IntPredicate isOdd = argument -> argument % 2 == 1;
        if (isEven.test(p)) {
            initiallyPageCount = p / 2;
            if (isEven.test(n)) {
                lastlyPageCount = (n - p) / 2;
            } else if (isOdd.test(n)) {
                lastlyPageCount = (n - p - 1) / 2;
            }
        } else if (isOdd.test(p)) {
            initiallyPageCount = (p - 1) / 2;
            if (isEven.test(n)) {
                lastlyPageCount = (n - p + 1) / 2;
            } else if (isOdd.test(n)) {
                lastlyPageCount = (n - p) / 2;
            }
        }
        return Math.min(initiallyPageCount, lastlyPageCount);
    }
}



