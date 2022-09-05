package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B5_BetweenTwoSets {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> arr = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> brr = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(arr);
        Collections.sort(brr);
        int total = ResultBetweenTwoSets.getTotalX(arr, brr);
        System.out.println(total);
    }
}

class ResultBetweenTwoSets {
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        Integer countNonFactor = 0;
        List<Integer> factors = new ArrayList<>();
        IntStream.range(a.stream().findFirst().get(), b.stream().findFirst().get() + 1).forEach(item -> {
            Boolean flag = true;
            for (Integer aItem : a) {
                if (item % aItem != 0) flag = false;
            }
            if (flag) factors.add(item);
        });
        for (Integer factor : factors) {
            for (Integer item : b) {
                if (item % factor != 0) {
                    countNonFactor++;
                    break;
                }
            }
        }
        return factors.size() - countNonFactor;
    }
}



