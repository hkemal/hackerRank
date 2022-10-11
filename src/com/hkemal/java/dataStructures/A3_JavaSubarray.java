package com.hkemal.java.dataStructures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A3_JavaSubarray {
    public static void main(String[] args) throws IOException {
        int negativSumSublistCount = 0;
        Scanner input = new Scanner(System.in);
        int maxArrayCount = input.nextInt();
        Integer[] numberArray = new Integer[maxArrayCount];
        for (int i = 0; i < maxArrayCount; i++) {
            numberArray[i] = input.nextInt();
        }
        List<Integer> numbers = Arrays.asList(numberArray);
        for (int countSublist = 1; countSublist <= maxArrayCount; countSublist++) {
            for (int j = 0; j <= maxArrayCount - countSublist; j++) {
                List<Integer> sublist = new ArrayList<>(numbers.subList(j, j + countSublist));
                Integer sum = sublist.stream().reduce(0, Integer::sum);
                if (sum < 0) {
                    negativSumSublistCount++;
                }
            }
        }
        System.out.println(negativSumSublistCount);
    }
}
