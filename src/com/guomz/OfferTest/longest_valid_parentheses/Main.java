package com.guomz.OfferTest.longest_valid_parentheses;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(("));
    }

    /**
     * 方法要点在于总结出两种情况的数学公式
     * 一种情况为()()
     * 另一种为()(())
     * 都算作有效括号
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        int maxLength = 0;
        //数组中每一位记录的是在字符串中以当前位为结尾的有效字串的长度
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i ++){
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '('){
                if (i - 2 >= 0){
                    //第一种情况公式
                    dp[i] = dp[i - 2] + 2;
                }else {
                    dp[i] = 2;
                }

            }
            else if(s.charAt(i) == ')' && s.charAt(i - 1) == ')'){
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    if (i - dp[i - 1] - 2 >= 0){
                        //第二种情况公式
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    }
                    else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
