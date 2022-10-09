package com.hkemal.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A3_JavaComparisons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            substrings.add(s.substring(i, i + k));
        }
        Collections.sort(substrings);
        smallest = substrings.get(0);
        largest = substrings.get(substrings.size() - 1);
        return smallest + "\n" + largest;
    }
}
