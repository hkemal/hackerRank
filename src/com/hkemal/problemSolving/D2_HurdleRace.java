package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D2_HurdleRace {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> height = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int result = ResultHurdleRace.hurdleRace(k, height);
        System.out.println(result);
    }
}

class ResultHurdleRace {
    /*
     * Complete the 'hurdleRace' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY height
     */

    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        Collections.sort(height);
        Integer maxHurdleHeight = height.get(height.size() - 1);
        if (k >= maxHurdleHeight) return 0;
        else return maxHurdleHeight - k;
    }
}



