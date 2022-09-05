package com.hkemal.problemSolving;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class A2_SimpleArraySum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer arCount = scanner.nextInt();
        Scanner scannerArr = new Scanner(System.in);
        List<Integer> ar = Stream.of(scannerArr.nextLine().split(" ")).map(Integer::parseInt).collect(toList());
        int result = ResultSimpleArraySum.simpleArraySum(ar);
        System.out.println(result);
    }
}

class ResultSimpleArraySum {
    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */
    public static int simpleArraySum(List<Integer> ar) {
        Integer total = ar.stream().reduce(0, (num1, num2) -> num1 + num2);
        return total;
    }
}

