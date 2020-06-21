package com.guomz.OfferTest.palindrome;

/**
 * 验证字符串是否是回文数，排除特殊字符与大小写
 */
public class Main {

    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s){
        if (s == null){
            return false;
        }
        if (s == ""){
            return true;
        }
        String numStr = "1234567890";
        String charStr = "abcdefghijklmnopqrstuvwxyz";
        s = s.trim().toLowerCase();
        char arr[] = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (true){
            if (i >= j){
                return true;
            }

            if (arr[i] == arr[j]){
                i ++;
                j --;
            }else {
                //一定要防止越界
                while (i <= arr.length - 1 && !numStr.contains(arr[i] + "") && !charStr.contains(arr[i] + "")){
                    i ++;
                }
                while (j >=0 && !numStr.contains(arr[j] + "") && !charStr.contains(arr[j] + "")){
                    j --;
                }
                //需要注意数组因为特殊字符而出现越界的问题
                if (i >= j){
                    return true;
                }
                if (arr[i] != arr[j]){
                    return false;
                }else {
                    i ++;
                    j --;
                    continue;
                }
            }
        }
    }
}
