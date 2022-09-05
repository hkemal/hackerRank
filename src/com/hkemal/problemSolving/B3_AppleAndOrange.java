package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B3_AppleAndOrange {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int s = Integer.parseInt(firstMultipleInput[0]);
        int t = Integer.parseInt(firstMultipleInput[1]);
        String[] secondMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int a = Integer.parseInt(secondMultipleInput[0]);
        int b = Integer.parseInt(secondMultipleInput[1]);
        String[] thirdMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int m = Integer.parseInt(thirdMultipleInput[0]);
        int n = Integer.parseInt(thirdMultipleInput[1]);
        List<Integer> apples = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> oranges = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        ResultAppleAndOrange.countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}

class ResultAppleAndOrange {
    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        final Integer[] countApple = {0};
        final Integer[] countOrange = {0};
        IntPredicate condition = item -> item >= s && item <= t;
        apples.stream().forEach(item -> {
            if (condition.test(a + item)) countApple[0]++;
        });
        oranges.stream().forEach(item -> {
            if (condition.test(b + item)) countOrange[0]++;
        });
        System.out.println(countApple[0] + "\n" + countOrange[0]);
    }
}



