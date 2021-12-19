package com.hkemal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class B1_TimeConversion {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        String convertedDate = ResultTimeConversion.timeConversion(date);
        System.out.println(convertedDate);
    }
}

class ResultTimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String date) throws ParseException {
        // Write your code here
        StringBuilder stringBuilderDate = new StringBuilder(date);
        stringBuilderDate.insert(8, " ");
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
        Date amPmDate = new SimpleDateFormat("hh:mm:ss aa").parse(stringBuilderDate.toString());
        String militaryFormat = dateformat.format(amPmDate);
        return militaryFormat;
    }
}



