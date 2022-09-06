package com.hkemal.java;

import java.util.Scanner;

public class B1_JavaIntToString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        try {
            Integer.parseInt(line);
            System.out.println("Good job");
        } catch (Exception e) {
            System.out.println("Wrong answer");
        }
    }
}
