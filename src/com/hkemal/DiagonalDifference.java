package com.hkemal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine().trim());
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(item -> {
            Scanner scannerArr = new Scanner(System.in);
            List<Integer> row = Stream.of(scannerArr.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
            arr.add(row);
        });
        int result = ResultDiagonalDifference.diagonalDifference(arr);
        System.out.println(result);
    }
}

class ResultDiagonalDifference {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        final Integer[] firstDiagonal = {0};
        final Integer[] secondDiagonal = {0};
        IntStream.range(0, arr.size()).forEach(item -> {
            firstDiagonal[0] += arr.get(item).get(item);
            secondDiagonal[0] += arr.get(item).get((arr.size() - 1) - item);
        });
        return Math.abs(firstDiagonal[0] - secondDiagonal[0]);
    }
}

