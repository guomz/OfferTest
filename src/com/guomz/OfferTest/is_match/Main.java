package com.guomz.OfferTest.is_match;

public class Main {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    public static boolean isMatch(String s, String p){
        if (p == null || s == null){
            return false;
        }
        //去掉匹配串开头的星号
        int numOfStar = 0;
        for (int i = 0; i < p.length(); i ++){
            if (p.charAt(i) == '*'){
                numOfStar ++;
            }
            else {
                break;
            }
        }
        if (numOfStar > 0){
            p = p.substring(0, numOfStar);
        }
        //这种是万能情况
        if (p.equals(".*")){
            return true;
        }
        return match(s, 0, p, 0);
    }

    private static boolean match(String s, int index1, String p, int index2){
        if (index1 == s.length() && index2 == p.length()){
            return true;
        }
        //匹配串先遍历完报错
        if (index2 == p.length()){
            return false;
        }

        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*'){
            if (index1 < s.length() && index2 < p.length() && (p.charAt(index2) == '.' || s.charAt(index1) == p.charAt(index2))){
                return match(s, index1 + 1, p, index2) ||
                        match(s, index1 + 1, p, index2 + 2) ||
                        match(s, index1, p, index2 + 2);
            }else {
                return match(s, index1, p, index2 + 2);
            }
        }

        if (index1 < s.length() && index2 < p.length() && (p.charAt(index2) == '.' || s.charAt(index1) == p.charAt(index2))){
            return match(s, index1 + 1, p, index2 + 1);
        }

        return false;
    }
}
