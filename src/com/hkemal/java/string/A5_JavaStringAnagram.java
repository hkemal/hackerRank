package com.hkemal.java.string;

import java.util.Arrays;
import java.util.Scanner;

public class A5_JavaStringAnagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] charsA = a.toCharArray();
        Arrays.sort(charsA);
        char[] charsB = b.toCharArray();
        Arrays.sort(charsB);
        if (charsA.length != charsB.length) {
            return false;
        } else {
            boolean anagramFlag = true;
            for (int i = 0; i < charsA.length; i++) {
                if (charsA[i] != charsB[i]) {
                    anagramFlag = false;
                    break;
                }
            }
            return anagramFlag;
        }
    }
}
