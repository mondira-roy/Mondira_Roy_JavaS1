package com.company;
import java.util.Scanner;
public class CountTo {

    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.print("Please Enter a number"+ System.lineSeparator());
        int num = Integer.parseInt(myscanner.nextLine());
        //int num = myscanner.nextLine();
     for(int i=0; i<=num ; i++){
         System.out.print(i + "\r\n");
     }
        //System.out.println(System.lineSeparator());
    }
}
