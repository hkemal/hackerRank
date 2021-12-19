package com.hkemal;

import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class A6_PlusMinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine().trim());
        Scanner scannerArr = new Scanner(System.in);
        List<Integer> arr = Stream.of(scannerArr.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
        ResultPlusMinus.plusMinus(arr);
    }
}

class ResultPlusMinus {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        Integer countPositive = 0;
        Integer countNegative = 0;
        Integer countZero = 0;

        IntPredicate isPositive = argument -> argument > 0;
        IntPredicate isNegative = argument -> argument < 0;
        IntPredicate isZero = argument -> argument == 0;
        for (Integer item : arr) {
            if (isPositive.test(item)) countPositive++;
            else if (isNegative.test(item)) countNegative++;
            else if (isZero.test(item)) countZero++;
        }

        System.out.println(String.format("%.6f", (float) countPositive / arr.size()));
        System.out.println(String.format("%.6f", (float) countNegative / arr.size()));
        System.out.println(String.format("%.6f", (float) countZero / arr.size()));
    }

}

