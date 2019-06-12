package com.company;
import java.util.Scanner;

public class SomeMath {
    public static void main(String[] args) {
        System.out.println();
    }
    public static int total5(int[] totalOfFive){
        int total=0;
        for ( int inttot: totalOfFive){
            total=total+inttot;

        }return total;

    }

 public static double average5(int[] avgOfFive){
       double avg;
       int numsum=0;
     for ( int element: avgOfFive){
         numsum= numsum+ element;
     }
     avg= numsum/avgOfFive.length;

     return avg;
    }

  public static double largest5(double[] largeArr){

          double large = Integer.MIN_VALUE;
          //int smallest = Integer.MAX_VALUE;
          for (double element : largeArr) {
              if (element> large) {
                  large = element;
              } return large;
              }return large;
          }
              }



//Create a method called ```total5```.
// This method must take 5 int parameters and return the total.
// You must call the method
//with the following parameters and print the returned total to the screen: 1, 2, 3, 4, 5.
//1. Create a method called ```average5```. This method must take 5 int
// parameters and return//the average of the numbers as a double.
// You must call the method with the following parameters
//and print the returned average to the screen: 1, 3, 5, 7, 9.
//1. Create a method called ```largest5```. This method must take 5 double parameters
//and return the largest. You must call the method with the following parameters and print the returned
//value to the screen: 42.0, 35.1, 2.3, 40.2, 15.6.


