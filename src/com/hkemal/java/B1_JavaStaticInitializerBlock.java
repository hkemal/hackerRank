package com.hkemal.java;

import java.util.Scanner;

public class B1_JavaStaticInitializerBlock {
    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }
    }

    static int B;
    static int H;
    static boolean flag = true;

    static {
        Scanner input = new Scanner(System.in);
        B = input.nextInt();
        H = input.nextInt();
        if (B <= 0 || H <= 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        input.close();
    }
}
