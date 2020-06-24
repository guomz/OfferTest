package com.guomz.OfferTest.add_binary;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "010"));
    }

    public static String addBinary(String a, String b) {
        if (a.contains("0") && !a.contains("1")){
            a = "0";
        }
        if (b.contains("0") && !b.contains("1")){
            b = "0";
        }

        char arrSum[] = new char[Math.max(a.length(), b.length()) + 1];
        String longStr;
        String shortStr;
        if (a.length() >= b.length()){
            longStr = a;
            shortStr = b;
        }
        else {
            longStr = b;
            shortStr = a;
        }
        longStr = "0" + longStr;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < longStr.length() - shortStr.length(); i ++){
            stringBuilder.append("0");
        }
        stringBuilder.append(shortStr);
        shortStr = stringBuilder.toString();
        int i = longStr.length() - 1;
        int j = shortStr.length() - 1;
        int k = arrSum.length - 1;
        int addOn = 0;
        for (; j >= 0; i --, j --, k --){
            char tempLongchar = longStr.charAt(i);
            char tempShortchar = shortStr.charAt(j);
            addOn = add(tempLongchar, tempShortchar, addOn, arrSum, k);
        }
        String result = new String(arrSum).trim();
        if (result.charAt(0) == '0'){
            result = result.substring(1);
        }
        return result;
    }

    private static int add(char a, char b, int addOn, char arrSum[], int index){
        if (a == '1' && b == '1') {
            if (addOn == 1){
                arrSum[index] = '1';
            }else{
                arrSum[index] = '0';
            }
            return 1;
        }
        else if (a == '0' && b =='0'){
            if (addOn == 1){
                arrSum[index] = '1';
            }else{
                arrSum[index] = '0';
            }
            return 0;
        }else {
            if (addOn == 1){
                arrSum[index] = '0';
                return 1;
            }else{
                arrSum[index] = '1';
                return 0;
            }
        }
    }
}
