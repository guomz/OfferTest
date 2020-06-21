package com.guomz.OfferTest.testString;

public class Main {

    public static void main(String[] args) {

//        String str1 = "a" + "bc";
//        String str2 = "ab" + "c";
//        System.out.println(str1 == str2); true

          String str1 = new String("a") + "bc";
          String str2 = new String("ab") + "c";
          System.out.println(str1 == str2); //false
    }
}
