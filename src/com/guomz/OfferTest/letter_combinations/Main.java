package com.guomz.OfferTest.letter_combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0){
            return new ArrayList<>();
        }

        dfs("", digits, 0);
        return strList;
    }

    String numArr[] = new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> strList = new ArrayList<>();

    /**
     * 思路为递归找出所有结果，递归深度取决于电话号码长度
     * @param str
     * @param digits
     * @param position
     */
    private void dfs(String str, String digits, int position){
        if (position == digits.length()){
            strList.add(str);
            return;
        }
        int index = Integer.parseInt(digits.charAt(position) + "");
        String charStr = numArr[index - 1];
        for (int i = 0; i < charStr.length(); i ++){
            String newStr = str + charStr.charAt(i);
            dfs(newStr, digits, position + 1);
        }
    }
}
