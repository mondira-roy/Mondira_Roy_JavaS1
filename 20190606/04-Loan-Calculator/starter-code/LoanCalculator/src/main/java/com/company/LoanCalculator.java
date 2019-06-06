package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner myscanner= new Scanner(System.in);
        System.out.println("PLease enter Mortgage amount");
        float amount= myscanner.nextFloat();
        System.out.println("PLease enter Mortgage term in months ");
        int term=myscanner.nextInt();
        System.out.println("PLease enter Mortgage Annual Rate");
        float ann_rate=myscanner.nextFloat();
        float m =(ann_rate/12f);
        float Loan_total; int term1= term*12; int i; float div=1f;
        for (i=1;i<=term;i++) {
            div=(1+m)*div;
        }
        Loan_total=amount*m*div/div-1;
        System.out.println("Calculated loan total:" + Loan_total);
    }
}
//P = L[c(1 + c)^n]/[(1 + c)^n - 1]