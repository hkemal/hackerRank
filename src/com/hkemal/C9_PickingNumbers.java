package com.hkemal;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C9_PickingNumbers {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());
        List<Integer> a = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int result = ResultPickingNumbers.pickingNumbers(a);
        System.out.println(result);
    }
}

class ResultPickingNumbers {
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        final Long[] max = {0L};
        List<Integer> distinctList = a.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);
        if (distinctList.size() == 1) max[0] = Long.valueOf(a.size());
        IntStream.range(0, distinctList.size() - 1).forEach(index -> {
            Long countPlus = a.stream().filter(
                    item -> item.equals(a.get(index)) || item.equals(a.get(index) + 1)
            ).count();
            Long countMinus = a.stream().filter(
                    item -> item.equals(a.get(index)) || item.equals(a.get(index) - 1)
            ).count();
            Long count = Math.max(countPlus, countMinus);
            if (count > max[0]) {
                max[0] = count;
            }
        });
        return Math.toIntExact(max[0]);
    }
}



