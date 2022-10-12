package com.hkemal.java.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A4_JavaArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalCount = input.nextInt();
        List<List<Integer>> numberList = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            int itemCount = input.nextInt();
            List<Integer> numberItemList = new ArrayList();
            for (int j = 0; j < itemCount; j++) {
                int item = input.nextInt();
                numberItemList.add(item);
            }
            numberList.add(numberItemList);
        }

        int printCount = input.nextInt();
        for (int k = 0; k < printCount; k++) {
            int row = input.nextInt();
            int col = input.nextInt();
            try {
                System.out.println(numberList.get(row - 1).get(col - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
        input.close();
    }
}
