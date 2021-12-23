package com.hkemal;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B6_BreakingTheRecords {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Integer> scores = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = ResultBreakingTheRecords.breakingRecords(scores);
        result.stream().forEach(item -> System.out.print(item + " "));
    }
}

class ResultBreakingTheRecords {
    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        final Integer[] greatRecord = {scores.get(0)};
        final Integer[] lowRecord = {scores.get(0)};
        final Integer[] greatersCount = {0};
        final Integer[] lowersCount = {0};
        BiPredicate<Integer, Integer> isGreater = (number1, number2) -> number1 > number2;
        BiPredicate<Integer, Integer> isLower = (number1, number2) -> number1 < number2;
        IntStream.range(0, scores.size()).forEach(item -> {
            if (isGreater.test(scores.get(item), greatRecord[0])) {
                greatersCount[0]++;
                greatRecord[0] = scores.get(item);
            }
            if (isLower.test(scores.get(item), lowRecord[0])) {
                lowersCount[0]++;
                lowRecord[0] = scores.get(item);
            }
        });
        List<Integer> results = Stream.of(greatersCount[0], lowersCount[0]).collect(Collectors.toList());
        return results;
    }
}



