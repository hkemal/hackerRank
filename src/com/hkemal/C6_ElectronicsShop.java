package com.hkemal;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class C6_ElectronicsShop {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] bnm = in.nextLine().split(" ");
        //in.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);
        int[] keyboards = new int[n];
        String[] keyboardsItems = in.nextLine().split(" ");
        //in.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }
        int[] drives = new int[m];
        String[] drivesItems = in.nextLine().split(" ");
        //in.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }
        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */
        int moneySpent = ResultElectronicsShop.getMoneySpent(keyboards, drives, b);
        System.out.println(moneySpent);
    }
}

class ResultElectronicsShop {
    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        final Integer[] maxTotalPrice = {-1};
        BiPredicate<Integer, Integer> maxTotalPriceCondition =
                (keyboard, drive) -> keyboard + drive <= b && keyboard + drive > maxTotalPrice[0];
        Arrays.stream(keyboards).forEach(keyboard -> {
            Arrays.stream(drives).forEach(drive -> {
                if (maxTotalPriceCondition.test(keyboard, drive)) {
                    maxTotalPrice[0] = keyboard + drive;
                }
            });
        });
        return maxTotalPrice[0];
    }
}



