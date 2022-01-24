package com.hkemal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class D9_CircularArrayRotation {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        int q = Integer.parseInt(firstMultipleInput[2]);
        List<Integer> a = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            return in.nextLine().replaceAll("\\s+$", "");
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = ResultCircularArrayRotation.circularArrayRotation(a, k, queries);
        result.stream().forEach(System.out::println);
    }
}

class ResultCircularArrayRotation {
    /*
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // Write your code here
        List<Integer> rotatedList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Integer rotationCount = k % a.size();
        if (rotationCount == 0) rotatedList = a;
        else {
            rotatedList = a.subList(a.size() - rotationCount, a.size());
            rotatedList.addAll(a.subList(0, a.size() - rotationCount));
        }
        List<Integer> finalRotatedList = rotatedList;
        IntStream.range(0, queries.size()).forEach(index -> {
            result.add(finalRotatedList.get(queries.get(index)));
        });
        return result;
    }
}



