package com.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Map<String,String> numbers = new HashMap<>();

        printKeys();
        System.out.println("=================");
        printValues();
        System.out.println("==================");
        printKeysAndValues();

    }
 public static void printKeys() {
     Map<String, String> numbers = new HashMap<>();
     numbers.put("1", "72");
     numbers.put("2", "63");
     numbers.put("3", "65");
     numbers.put("4", null);
     numbers.put("5", "55");
     Set<String> myKeys = numbers.keySet();
     for (String key : myKeys) {
         System.out.println(key);
     }
 }
  public static void printValues(){
         Map<String, String> numbers = new HashMap<>();
         numbers.put("1","72");
         numbers.put("2","63");
         numbers.put("3","65");
         numbers.put("4", null);
         numbers.put("5" , "55");
         Collection<String > myValues = numbers.values() ;
      //Collection<String > myKeys = numbers.value() ;
         for(String value: myValues){
             System.out.println(value);}
  }
  public static void printKeysAndValues(){
      //Map<String,String> numbers1 = new HashMap<>();
      Map<String, String> numbers = new HashMap<>();
      numbers.put("1", "72");
      numbers.put("2", "63");
      numbers.put("3", "65");
      numbers.put("4", null);
      numbers.put("5", "55");
      Set<String> myKeys = numbers.keySet();
         Set<Map.Entry<String, String>> myEntries = numbers.entrySet();
         for (Map.Entry<String,String> entry: myEntries) {
         System.out.println("Key: " + entry.getKey() + " Value: "
                     + entry. getValue());
         }
     }

}
