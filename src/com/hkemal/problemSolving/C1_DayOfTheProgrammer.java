package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class C1_DayOfTheProgrammer {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int year = Integer.parseInt(in.nextLine().trim());
        String result = ResultDayOfTheProgrammer.dayOfProgrammer(year);
        System.out.println(result);
    }
}

class ResultDayOfTheProgrammer {
    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    public static String dayOfProgrammer(int year) {
        // Write your code here
        IntPredicate leapYearCondition =
                (
                        item -> (
                                (item < 1918) && item % 4 == 0) ||
                                (item > 1918 && ((item % 4 == 0 && item % 100 != 0) || (item % 400 == 0))
                                )
                );
        if (leapYearCondition.test(year)) {
            return "12.09." + year;
        } else if (year == 1918) {
            return "26.09.1918";
        } else {
            return "13.09." + year;
        }
    }
}



