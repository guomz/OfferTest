package com.guomz.OfferTest.palindrome_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        String words[] = {"a",""};
        System.out.println(palindromePairs(words));
    }

    /**
     * 当一个长字符串和短字符串能够组成回文串时，长串会包含短串的反转且长串剩余的部分也为回文串
     * 可以遍历数组将每个元素当作长串，分别判断其左右每个子串是否是其他字符串的反转，并判断剩余部分是否是回文
     * 注意空字符串与长短串长度相同的情况
     * @param words
     * @return
     */
    public static List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0){
            return new ArrayList<>();
        }
        Map<String, Integer> strMap = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i ++){
            strMap.put(words[i], i);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < words.length; i ++){
            if (words[i].length() == 0){
                continue;
            }
            for (int j = 0; j < words[i].length() - 1; j ++){
                String left = words[i].substring(0, j + 1);
                String right = words[i].substring(j + 1);
                //判断左前缀
                String leftReverse = getReverse(left);
                if (strMap.containsKey(leftReverse) && isPalindrome(right)){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(strMap.get(leftReverse));
                    resultList.add(tempList);
                }
                //判断右前缀
                String rightReverse = getReverse(right);
                if (strMap.containsKey(rightReverse) && isPalindrome(left)){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(strMap.get(rightReverse));
                    tempList.add(i);
                    resultList.add(tempList);
                }
            }
            //全部判断
            String allReverse = getReverse(words[i]);
            if (strMap.containsKey(allReverse) && strMap.get(allReverse) != i) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                tempList.add(strMap.get(allReverse));
                resultList.add(tempList);
            }
            //判断空串情况
            if (isPalindrome(words[i]) && strMap.containsKey("")){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i);
                tempList.add(strMap.get(""));
                resultList.add(tempList);
                List<Integer> tempList2 = new ArrayList<>();
                tempList2.add(strMap.get(""));
                tempList2.add(i);
                resultList.add(tempList2);
            }
        }
        return resultList;
    }

    /**
     * 判断传入的字符串是否为回文串
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) == str.charAt(j)){
                i ++;
                j --;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 得到传入字符串的反转串
     * @param str
     * @return
     */
    private static String getReverse(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i --){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
