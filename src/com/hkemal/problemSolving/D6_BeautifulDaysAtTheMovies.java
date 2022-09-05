package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class D6_BeautifulDaysAtTheMovies {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int i = Integer.parseInt(firstMultipleInput[0]);
        int j = Integer.parseInt(firstMultipleInput[1]);
        int k = Integer.parseInt(firstMultipleInput[2]);
        int result = ResultBeautifulDaysAtTheMovies.beautifulDays(i, j, k);
        System.out.println(result);
    }
}

class ResultBeautifulDaysAtTheMovies {
    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        BiPredicate<Integer, Integer> beautifulDayCondition =
                (number, denominator) -> Math.abs(number - getReverseInteger(number)) % denominator == 0;
        final Integer[] countBeautifulDays = {0};
        IntStream.range(i, j + 1).forEach(index -> {
            if (beautifulDayCondition.test(index, k)) {
                countBeautifulDays[0]++;
            }
        });
        return countBeautifulDays[0];
    }

    public static int getReverseInteger(Integer number) {
        List<String> numberList = Arrays.asList(String.valueOf(number).split(""));
        Collections.reverse(numberList);
        String iReverseString = String.join("", numberList);
        Integer numberReverse = Integer.valueOf(iReverseString);
        return numberReverse;
    }
}



