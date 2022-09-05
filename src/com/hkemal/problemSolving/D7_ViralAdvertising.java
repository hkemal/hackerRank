package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class D7_ViralAdvertising {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        int result = ResultViralAdvertising.viralAdvertising(n);
        System.out.println(result);
    }
}

class ResultViralAdvertising {
    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int viralAdvertising(int n) {
        // Write your code here
        final Integer[] currentPeopleCount = {5};
        final Integer[] result = {0};
        IntStream.range(0, n).forEach(index -> {
            Integer sharedPeople = currentPeopleCount[0] / 2;
            result[0] += sharedPeople;
            currentPeopleCount[0] = sharedPeople * 3;
        });
        return result[0];
    }
}



