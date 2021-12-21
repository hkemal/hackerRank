package com.hkemal;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class A4_AVeryBigSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer arCount = scanner.nextInt();
        Scanner scannerArr = new Scanner(System.in);
        List<Long> ar = Stream.of(scannerArr.nextLine().split(" ")).map(Long::parseLong).collect(toList());
        Long result = ResultAVeryBigSum.aVeryBigSum(ar);
        System.out.println(result);
    }
}

class ResultAVeryBigSum {
    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */
    public static long aVeryBigSum(List<Long> ar) {
        Long total = ar.stream().reduce(0L, (num1, num2) -> num1 + num2);
        return total;
    }
}

