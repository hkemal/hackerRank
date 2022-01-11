package com.hkemal;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B9_MigratoryBirds {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int arrCount = Integer.parseInt(in.nextLine().trim());
        List<Integer> arr = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int result = ResultMigratoryBirds.migratoryBirds(arr);
        System.out.println(result);
    }
}

class ResultMigratoryBirds {
    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        Integer lowestMostFrequency = 0;
        Integer maxCount = 0;
        Integer count = 0;
        BiPredicate<Integer, Integer> isGreaterOrEqual = (number1, number2) -> number1 >= number2;
        for (int i = arr.size() - 2; i > 0; i--) {
            if (arr.get(i) == arr.get(i + 1)) {
                count++;
                if (isGreaterOrEqual.test(count, maxCount)) {
                    lowestMostFrequency = arr.get(i);
                    maxCount = count;
                }
            } else count = 0;
        }
        return lowestMostFrequency;
    }
}



