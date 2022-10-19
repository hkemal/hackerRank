package com.hkemal.java.dataStructures;

import java.util.HashSet;
import java.util.Scanner;

public class A9_JavaHashSet {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet<String> myHashSet = new HashSet<>();
        for (int i = 0; i < t; i++) {
            myHashSet.add(pair_right[i] + " " + pair_left[i]);
            System.out.println(myHashSet.size());
        }
    }
}
