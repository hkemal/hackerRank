package com.hkemal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class D4_UtopianTree {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine().trim());
        List<Integer> testCasesIndexes = new ArrayList<>();
        IntStream.range(0, t).forEach(tItr -> {
            int n = Integer.parseInt(in.nextLine().trim());
            testCasesIndexes.add(n);
        });
        ResultUtopianTree.utopianTree(new ResultUtopianTree().setHeights(), testCasesIndexes);
    }

}

class ResultUtopianTree {
    /*
     * Complete the 'utopianTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static void utopianTree(List<Integer> heights, List<Integer> testCasesIndex) {
        // Write your code here
        testCasesIndex.stream().forEach(item -> System.out.println(heights.get(item)));
    }

    public List<Integer> setHeights() {
        List<Integer> myHeightList = new ArrayList<>();
        final Integer[] height = {0};
        IntStream.range(0, 60).forEach(item -> {
            if (item % 2 == 0) {
                height[0] += 1;
                myHeightList.add(height[0]);
            } else {
                height[0] *= 2;
                myHeightList.add(height[0]);
            }
        });
        return myHeightList;
    }
}



