package com.hkemal.java.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5_Java1DArrayPart2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int jumpSize = scan.nextInt();
            List<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arrayList.add(scan.nextInt());
            }
            System.out.println((canWin(jumpSize, arrayList)) ? "YES" : "NO");
        }
        scan.close();
    }

    public static boolean canWin(int jumpSize, List<Integer> arrayList) {
        return isSolvable(jumpSize, arrayList, 0);
    }

    private static boolean isSolvable(int jumpSize, List<Integer> arrayList, int index) {
        if (index < 0 || arrayList.get(index) == 1) return false;
        if ((index == arrayList.size() - 1) || index + jumpSize > arrayList.size() - 1) return true;
        arrayList.set(index, 1);
        return isSolvable(jumpSize, arrayList, index + 1) ||
                isSolvable(jumpSize, arrayList, index - 1) ||
                isSolvable(jumpSize, arrayList, index + jumpSize);
    }
}
