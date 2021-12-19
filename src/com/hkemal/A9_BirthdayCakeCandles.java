package com.hkemal;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class A9_BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer candlesCount = scanner.nextInt();
        Scanner scannerArr = new Scanner(System.in);
        List<Integer> candles = Stream.of(scannerArr.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
        int result = ResultBirthdayCakeCandles.birthdayCakeCandles(candles);
        System.out.println(result);
    }
}

class ResultBirthdayCakeCandles {
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        return Collections.frequency(candles, Collections.max(candles));
    }
}

