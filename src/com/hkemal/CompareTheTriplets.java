package com.hkemal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CompareTheTriplets {
    public static void main(String[] args) throws IOException {
        Scanner scannerA = new Scanner(System.in);
        List<Integer> a = Stream.of(scannerA.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
        Scanner scannerB = new Scanner(System.in);
        List<Integer> b = Stream.of(scannerB.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
        List<Integer> result = ResultCompareTheTriplets.compareTriplets(a, b);
    }
}

class ResultCompareTheTriplets {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        final Integer[] countA = {0};
        final Integer[] countB = {0};
        IntStream.range(0, a.size()).forEach(index -> {
            if (a.get(index) > b.get(index)) countA[0]++;
            else if (a.get(index) < b.get(index)) countB[0]++;
        });
        result.add(countA[0]);
        result.add(countB[0]);
        return result;
    }

}

