package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D5_AngryProfessor {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int k = Integer.parseInt(firstMultipleInput[1]);
            List<Integer> a = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            String result = ResultAngryProfessor.angryProfessor(k, a);
            System.out.println(result);
        });

    }
}

class ResultAngryProfessor {
    /*
     * Complete the 'angryProfessor' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY a
     */
    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here
        final Integer[] punctualStudentCount = {0};
        IntPredicate punctualCondition = minute -> minute <= 0;
        BiPredicate<Integer, Integer> classCancelCondition = (studentCount, threshold) -> studentCount >= threshold;
        a.stream().forEach(item -> {
            if (punctualCondition.test(item)) {
                punctualStudentCount[0]++;
            }
        });
        if (classCancelCondition.test(punctualStudentCount[0], k)) {
            return "NO";
        }
        return "YES";
    }
}



