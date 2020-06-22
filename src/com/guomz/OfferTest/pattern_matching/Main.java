package com.guomz.OfferTest.pattern_matching;

/**
 * 你有两个字符串，即pattern和value。
 * pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(patternMatching("abba", "dogcatcatdog"));
    }

    public static boolean patternMatching(String pattern, String value) {
        if (pattern == null || value == null){
            return false;
        }
        //匹配串为空返回失败
        if (pattern.equals("") && !value.equals("")){
            return false;
        }
        //被匹配串为空且匹配串同时包含a b则报错，因为ab不能同时表示空
        if (value.equals("") && pattern.contains("a") && pattern.contains("b")){
            return false;
        }
        //被匹配串为空但是匹配串都为a或b则成功，即a表示""
        if (value.equals("") && pattern.contains("a") && !pattern.contains("b")){
            return true;
        }

        if (value.equals("") && !pattern.contains("a") && pattern.contains("b")){
            return true;
        }
        return match(pattern, 0, value, 0, null, null);
    }

    private static boolean match(String pattern, int index1, String value, int index2, String aPart, String bPart){
        //两个串同时比较完成则成功
        if (index1 == pattern.length() && index2 == value.length()){
            return true;
        }
        //任意一个到头另一个没到头不成功
        if (index1 == pattern.length() || index2 > value.length()){
            return false;
        }

        if (pattern.charAt(index1) == 'a'){
            //匹配串当前是a
            if (aPart == null){
                //第一次进入或上一次a不成功
                for (int i = index2; i <= value.length(); i ++){
                    //循环截取被匹配串
                    aPart = value.substring(index2, i);
                    if (!aPart.equals(bPart) && match(pattern, index1 + 1, value, i, aPart, bPart)){
                        return true;
                    }
                }
                aPart = null;
                return false;
            }else {
                //已经在匹配中，计算被匹配串下一个位置
                int nextIndex = index2 + aPart.length();
                if (nextIndex > value.length() || !aPart.equals(value.substring(index2, nextIndex))){
                    return false;
                }
                return match(pattern, index1 + 1, value, nextIndex, aPart, bPart);
            }
        }else {
            if (bPart == null){
                //第一次进入或上一次a不成功
                for (int i = index2; i <= value.length(); i ++){
                    bPart = value.substring(index2, i);
                    if (!bPart.equals(aPart) && match(pattern, index1 + 1, value, i, aPart, bPart)){
                        return true;
                    }
                }
                bPart = null;
                return false;
            }else {
                //已经在匹配中
                int nextIndex = index2 + bPart.length();
                if (nextIndex > value.length() || !bPart.equals(value.substring(index2, nextIndex))){
                    return false;
                }
                return match(pattern, index1 + 1, value, nextIndex, aPart, bPart);
            }
        }
    }
}
