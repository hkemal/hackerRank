package com.hkemal;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D3_DesignerPDFViewer {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        List<Integer> h = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String word = in.nextLine();
        int result = ResultDesignerPDFViewer.designerPdfViewer(h, word);
        System.out.println(result);
    }
}

class ResultDesignerPDFViewer {
    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */
    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        String alphabet = "abcdefghijklmnopqrstuvwxvyz";
        final Integer[] maxHeight = {0};
        Arrays.stream(word.split("")).forEach(item -> {
            if (maxHeight[0] < h.get(alphabet.indexOf(item.toLowerCase()))) {
                maxHeight[0] = h.get(alphabet.indexOf(item.toLowerCase()));
            }
        });
        return maxHeight[0] * word.length();
    }
}



