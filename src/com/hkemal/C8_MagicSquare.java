package com.hkemal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C8_MagicSquare {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> s = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> {
            s.add(
                    Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList())
            );
        });
        int result = ResultMagicSquare.formingMagicSquare(s);
        System.out.println(result);
    }

}

class ResultMagicSquare {
    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        final Integer[] absouluteDifference = {100};
        List<List<List<Integer>>> wholeMagicSquares = new ArrayList<>();
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{2, 7, 6}), Arrays.asList(new Integer[]{9, 5, 1}), Arrays.asList(new Integer[]{4, 3, 8})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{2, 9, 4}), Arrays.asList(new Integer[]{7, 5, 3}), Arrays.asList(new Integer[]{6, 1, 8})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{4, 3, 8}), Arrays.asList(new Integer[]{9, 5, 1}), Arrays.asList(new Integer[]{2, 7, 6})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{4, 9, 2}), Arrays.asList(new Integer[]{3, 5, 7}), Arrays.asList(new Integer[]{8, 1, 6})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{6, 1, 8}), Arrays.asList(new Integer[]{7, 5, 3}), Arrays.asList(new Integer[]{2, 9, 4})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{6, 7, 2}), Arrays.asList(new Integer[]{1, 5, 9}), Arrays.asList(new Integer[]{8, 3, 4})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{8, 1, 6}), Arrays.asList(new Integer[]{3, 5, 7}), Arrays.asList(new Integer[]{4, 9, 2})));
        wholeMagicSquares.add(Arrays.asList(Arrays.asList(new Integer[]{8, 3, 4}), Arrays.asList(new Integer[]{1, 5, 9}), Arrays.asList(new Integer[]{6, 7, 2})));
        wholeMagicSquares.stream().forEach(item -> {
            if (ResultMagicSquare.findAbsouluteDifference(item, s) < absouluteDifference[0]) {
                absouluteDifference[0] = ResultMagicSquare.findAbsouluteDifference(item, s);
            }
        });
        return absouluteDifference[0];
    }

    public static Integer findAbsouluteDifference(List<List<Integer>> firstList, List<List<Integer>> secondList) {
        Integer difference = 0;
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < firstList.size(); j++) {
                difference += Math.abs(firstList.get(i).get(j) - secondList.get(i).get(j));
            }
        }
        return difference;
    }
}



