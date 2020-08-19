package com.guomz.OfferTest.count_sub_strings;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(countSubstrings("fdsklf"));
    }

    /**
     * 如果遍历每个字符为开头或结尾去枚举回文串会出现立方级别的算法
     * 所以采用遍历回文中心的方法，时间复杂度为平方
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s == null){
            return 0;
        }
        if (s.length() == 0){
            return 1;
        }

        int result = 0;
        //枚举所有的回文中心，分回文串长度为奇数偶数的情况
        for (int i = 0; i < s.length(); i ++){
            //先判断回文串为奇数长度的情况，即回文中心为一个字符
            int j = i;
            int k = i;
            result += checkStr(s, j, k);
            //判断长度为偶数的情况，即回文中心为两个字符
            j = i;
            k = i + 1;
            result += checkStr(s, j, k);
        }

        return result;
    }

    /**
     * 由回文中心向两侧扩散，遇到两指针不相同则推出
     * @param s
     * @param j
     * @param k
     * @return
     */
    private static int checkStr(String s, int j, int k){
        int result = 0;
        while (j >= 0 && k < s.length()){
            if (s.charAt(j) == s.charAt(k)){
                result ++;
                j --;
                k ++;
            }else {
                break;
            }
        }
        return result;
    }

}
