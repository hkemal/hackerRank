package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B8_DivisibleSumPairs {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> ar = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int result = ResultDivisibleSumPairs.divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }
}

class ResultDivisibleSumPairs {
    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        final Integer[] count = {0};
        BiPredicate<Integer, Integer> isDivisible = (number1, number2) -> number1 % number2 == 0;
        IntStream.range(0, ar.size()).forEach(item -> {
            IntStream.range(item + 1, ar.size()).forEach(x -> {
                if ((isDivisible.test((ar.get(item) + ar.get(x)), k))) count[0]++;
            });
        });
        return count[0];
    }
}



