package com.company;
import jdk.management.resource.internal.TotalResourceContext;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Please Enter The width of the driveway:");
        int width= number.nextInt();
        System.out.println("Please enter the length of the driveway");
        int length = number.nextInt();
        System.out.println("Please Enter The cost of cement:");
        float cement= number.nextFloat();
        System.out.println("Please Enter The cost of framing:");
         float framing= number.nextFloat();

         float area = width * length;
        float perimeter= 2f*(width+length);
        float total = (12.50f*area)+(8.25f*perimeter);
        float total2= (cement*area) + (framing*perimeter);

        System.out.format("The area of the driveway is %.2f \n", area);
        //System.out.println("The area of the driveway is=" + area);
        System.out.format("The perimeter of the driveway is %.2f \n", perimeter);
        System.out.format("The sub Total cost for the cement is $ %.2f \n" , (area*12.50f));
        System.out.format("The sub Total cost for the framing is = $ %.2f \n" , (perimeter*8.25f));
        System.out.format("The total cost for paving the driveway is = $ %.2f", total);
        //System.out.format("The perimeter of the driveway is %.2f \n", perimeter);
        System.out.format("The sub Total cost for the cement is $ %.2f \n" , (cement*area));
        System.out.format("The sub Total cost for the framing is = $ %.2f \n" , (framing*perimeter));
        System.out.format("The total cost for paving the driveway is = $ %.2f", total2);

    }
}
