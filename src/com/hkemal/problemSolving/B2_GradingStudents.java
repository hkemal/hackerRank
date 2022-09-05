package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class B2_GradingStudents {
    public static void main(String[] args) throws ParseException {
        List<Integer> grades = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Integer gradesCount = in.nextInt();
        IntStream.range(0, gradesCount).forEach(item -> {
            Scanner scannerArr = new Scanner(System.in);
            Integer grade = scannerArr.nextInt();
            grades.add(grade);
        });
        List<Integer> results = ResultGradingStudents.gradingStudents(grades);
        results.stream().forEach(System.out::println);
    }
}

class ResultGradingStudents {
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        IntPredicate condition = item -> item >= 38 && ((item + 1) % 5 == 0 || (item + 2) % 5 == 0);
        IntStream.range(0, grades.size()).forEach(item -> {
            if (condition.test(grades.get(item))) {
                grades.set(item, ((grades.get(item) / 5) + 1) * 5);
            }
        });
        return grades;
    }
}



