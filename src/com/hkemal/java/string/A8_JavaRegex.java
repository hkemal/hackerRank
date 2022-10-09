package com.hkemal.java.string;

import java.util.Scanner;

public class A8_JavaRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex {

    String pattern = "^(([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5])\\.){3}([0-1]?[0-9]?[0-9]?|2[0-4][0-9]|25[0-5]){1}$";
}
