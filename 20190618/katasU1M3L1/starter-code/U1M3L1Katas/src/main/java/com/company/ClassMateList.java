package com.company;

import java.util.ArrayList;
import java.util.List;

import static com.sun.deploy.config.JREInfo.getAll;

public class ClassMateList {
    public static void main(String[] args) {
        //create List
        List<ClassMate> classmate = new ArrayList<>();

        //Add classMate Objects
        ClassMate cmate1 = new ClassMate("Brian", "blonde");
        classmate.add(cmate1);
        ClassMate cmate2 = new ClassMate("Jordan", "red");
        classmate.add(cmate2);
        ClassMate cmate3 = new ClassMate("AL", "grey");
        classmate.add(cmate3);
        ClassMate cmate4 = new ClassMate("Maria", "black");
        classmate.add(cmate4);
        ClassMate cmate5 = new ClassMate("Meredith", "brown");
        classmate.add(cmate5);

        System.out.println(classmate.size());

        add();
        //System.out.println(getAll());

    }

    public static void add() {
        List<ClassMate> classmate = new ArrayList<>();
        ClassMate cmate6 = new ClassMate("Meg", "blonde");
        classmate.add(cmate6);
    }

    public static int get() {
        List<ClassMate> classmate = new ArrayList<>();
        for (ClassMate temp : classmate) {
            System.out.println(temp.getName());
        }
        Integer size = classmate.size();
        return size;
    }

    public static void getAll() {
        List<ClassMate> classmate = new ArrayList<>();
        for (ClassMate temp : classmate) {
            System.out.println("Name " + temp.getName() + " HairColor " +
                    temp.getHairColor());
        }
    }
}