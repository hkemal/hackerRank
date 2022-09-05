package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class C3_SalesByMatch {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Integer> ar = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());
        int result = ResultSalesByMatch.sockMerchant(n, ar);
        System.out.println(result);
    }
}

class ResultSalesByMatch {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        final Long[] totalPairs = {0L};
        Set<Integer> targetSet = new HashSet<>(ar);
        targetSet.stream().forEach(item -> {
            Long countElement = ar.stream().filter(x -> x == item).count();
            totalPairs[0] += countElement / 2;
        });
        return Math.toIntExact(totalPairs[0]);
    }
}



