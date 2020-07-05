package com.guomz.OfferTest.is_match;

public class Main2 {

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
