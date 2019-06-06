package com.company;

import java.util.Scanner;

import static java.lang.System.*;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(in);
        System.out.println("Please Enter a number");
        //int num = Integer.parseInt(myscanner.nextLine());
        //int num = myscanner.nextLine();
        int count= 0;
        int num= myscanner.nextInt();
        for(int i=0; i<=num ;i=i+2) {
            System.out.println(i + "\r\n");
            count = count + 1;
        }
        out.println("The count by 2 =" + count);

        }
    }
