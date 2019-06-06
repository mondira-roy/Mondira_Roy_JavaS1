package com.company;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int num = Integer.parseInt(myscanner.nextLine());
        //int num = myscanner.nextLine();
        //int num = myscanner.nextInt();
        int count=0;
        for(int i = 1; i <= num; i = i + 13) {
            System.out.println(i + "\r\n");
            count= count + 1;
        }
        System.out.println("count is =" + count);
    }
}