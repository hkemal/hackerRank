package com.hkemal.java.string;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6_JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] words = s.split("[!,?._'@ ]");
        List<String> wordList = Arrays.stream(words).filter(item -> !item.isEmpty()).collect(Collectors.toList());
        System.out.println(wordList.size());
        wordList.forEach(System.out::println);
        scan.close();
    }
}
