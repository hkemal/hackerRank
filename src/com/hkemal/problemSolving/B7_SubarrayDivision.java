package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B7_SubarrayDivision {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Integer> s = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int d = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        Integer result = ResultSubarrayDivision.birthday(s, d, m);
        System.out.println(result);
    }
}

class ResultSubarrayDivision {
    /*
     * Complete the 'birthday' function below.     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        final Integer[] count = {0};
        BiPredicate<Integer, Integer> isEqual = (number1, number2) -> number1.equals(number2);
        IntStream.range(0, s.size() - m + 1).forEach(item -> {
            List<Integer> subList = new ArrayList<>();
            IntStream.range(item, item + m).forEach(x -> subList.add(s.get(x)));
            Integer total = subList.stream().reduce(0, (num1, num2) -> num1 + num2);
            if (isEqual.test(total, d)) count[0]++;
        });
        return count[0];
    }
}



