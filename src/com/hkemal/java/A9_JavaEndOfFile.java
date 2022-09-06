package com.hkemal.java;

import java.util.Scanner;

public class A9_JavaEndOfFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = 0;
        while (input.hasNextLine()) {
            System.out.println(++row + " " + input.nextLine());
        }
    }
}
