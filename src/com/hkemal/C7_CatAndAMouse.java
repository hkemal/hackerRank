package com.hkemal;

import java.util.Scanner;

public class C7_CatAndAMouse {
    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        Integer distaceCatA = Math.abs(x - z);
        Integer distaceCatB = Math.abs(y - z);
        if (distaceCatA > distaceCatB) return "Cat B";
        else if (distaceCatA < distaceCatB) return "Cat A";
        else return "Mouse C";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = in.nextLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);
            String result = catAndMouse(x, y, z);
            System.out.println(result);
        }
    }
}



