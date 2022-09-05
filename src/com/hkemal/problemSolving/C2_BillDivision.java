package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class C2_BillDivision {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String[] firstMultipleInput = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> bill = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());
        int b = Integer.parseInt(in.nextLine().trim());
        ResultBillDivision.bonAppetit(bill, k, b);
    }
}

class ResultBillDivision {
    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        Integer sumOfWholeBill = bill.stream().reduce(0, (x, y) -> x + y);
        Integer sumOfShared = sumOfWholeBill - bill.get(k);
        Integer eachPieceOfShared = sumOfShared / 2;
        if (b == eachPieceOfShared.intValue()) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - eachPieceOfShared);
        }
    }
}



