package com.guomz.OfferTest.is_match;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main2 {

    /**
     * 动态规划解法，额外创建二维数组，记录s的前i个字符串与p的前j个是否匹配
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "*"));
    }

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        if (s.equals("")){
            for (int i = 0; i < p.length(); i ++){
                if (p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        /**
         * 边界情况，初始00为true
         * 匹配串为空即dp i 0 都为false
         * 若字符串为空即dp 0 j 则需要判断j是否为*
         */
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i ++){
            if (p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }

        for (int i = 1; i <= s.length(); i ++){
            for (int j = 1; j <= p.length(); j ++){
                if (p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else if (p.charAt(j - 1) == s.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
