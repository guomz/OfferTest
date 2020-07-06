package com.guomz.OfferTest.hw_exam;

import org.omg.CORBA.INTERNAL;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(countNum());
    }

    private static int countNum(){
        Scanner sc = new Scanner(System.in);
        String k = sc.next();
        String n = sc.next();
        String m = sc.next();
        if (k == null || n == null || m == null){
            return 0;
        }
        if (k.equals("") || n.equals("") || m.equals("")){
            return 0;
        }
        if (!isNum(k) || !isNum(n) || !isNum(m)){
            return 0;
        }
        if (m.equals("0") || m.equals("1")){
            return 0;
        }
        if (Integer.parseInt(n) >= Integer.parseInt(m)){
            return 0;
        }
        String foreignNum = Integer.toString(Integer.parseInt(k), Integer.parseInt(m));
        System.out.println(foreignNum);
        int count = 0;
        for (int i = 0; i + n.length() <= foreignNum.length(); i ++){
            if (n.equals(foreignNum.substring(i, i + n.length()))){
                count ++;
            }
        }
        return count;
    }

    private static boolean isNum(String str){
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) > '9' || str.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
}
