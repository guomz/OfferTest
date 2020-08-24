package com.guomz.OfferTest.repeated_substring_pattern;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    /**
     * 下面方法属于枚举
     * 此外可以使用一个数学定律直接判断：我们将两个s连在一起，并移除第一个和最后一个字符。如果s是该字符串的子串，那么s就满足题目要求。
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        if (s == null){
            return false;
        }
        if (s.length() == 0 || s.length() == 1){
            return false;
        }

        for (int i = 1; i <= s.length()/2; i ++){
            if (s.length() % i != 0){
                continue;
            }
            String tempStr = s.substring(0, i);
            if (s.split(tempStr).length == 0){
                return true;
            }
        }
        return false;
    }
}
