package com.company;

import java.util.*;

public class SetIterator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Map<Integer, Integer> numbers = new HashMap<>();


         printSets();
    }

    public static void printSets(){
        Map<Integer, Integer> numbers = new HashMap<>();
        List<String> numbers1 = new ArrayList<>();
        numbers.put(1,72);
        numbers.put(2,63);
        numbers.put(3,65);
        numbers.put(4,null);
        numbers.put(5,55);
        Collection<Integer> myValues = numbers.values() ;

        Iterator<String> iter = numbers1.iterator();
        while(iter. hasNext()){
            System.out.println(iter.next());
        }
      //  for(Integer num: myValues){
        //    System.out.println(num);}
    }


}
