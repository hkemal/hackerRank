package com.hkemal;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C5_CountingValleys {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int steps = Integer.parseInt(in.nextLine().trim());
        String path = in.nextLine();
        int result = ResultCountingValleys.countingValleys(steps, path);
        System.out.println(result);
    }
}

class ResultCountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        // Write your code here
        final Integer[] startingPoint = {0};
        final Integer[] valleyCount = {0};
        List<String> pathChars = Arrays.asList(path.split(""));
        pathChars.stream().forEach(item -> {
            if (item.equals("D")) {
                if (startingPoint[0].equals(0)) {
                    valleyCount[0]++;
                }
                startingPoint[0] -= 1;
            } else if (item.equals("U")) {
                startingPoint[0] += 1;
            }
        });
        return valleyCount[0];
    }
}



