package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Scanner;

public class B4_NumberLineJump {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int x1 = Integer.parseInt(firstMultipleInput[0]);
        int v1 = Integer.parseInt(firstMultipleInput[1]);
        int x2 = Integer.parseInt(firstMultipleInput[2]);
        int v2 = Integer.parseInt(firstMultipleInput[3]);
        String result = ResultNumberLineJump.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}

class ResultNumberLineJump {
    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        String result = "NO";
        for (int t = 1; t <= 10000; t++) {
            if ((x1 + v1 * t) == (x2 + v2 * t)) result = "YES";
            if ((x1 + v1 * t) > (x2 + v2 * t)) break;
        }
        return result;
    }
}



