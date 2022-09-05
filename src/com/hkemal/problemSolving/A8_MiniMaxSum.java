package com.hkemal.problemSolving;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class A8_MiniMaxSum {
    public static void main(String[] args) {
        Scanner scannerArr = new Scanner(System.in);
        List<Long> ar = Stream.of(scannerArr.nextLine().split(" ")).map(Long::parseLong).collect(toList());
        ResultMiniMaxSum.miniMaxSum(ar);
    }
}

class ResultMiniMaxSum {
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        Long max = Collections.max(arr);
        Long min = Collections.min(arr);
        Long total = arr.stream().reduce(0L, (num1, num2) -> num1 + num2);
        System.out.println(total - max + " " + (total - min));
    }
}

