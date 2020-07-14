package com.guomz.OfferTest.minimum_total;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        List<List<Integer>> traingle = new ArrayList<>();
        traingle.add(Arrays.asList(2));
        traingle.add(Arrays.asList(3,4));
        traingle.add(Arrays.asList(6,5,7));
        traingle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(traingle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        int dp[][] = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i ++){
            dp[i] = new int[triangle.get(i).size()];
        }
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 0; i < triangle.size(); i ++){
            for (int j = 0; j < triangle.get(i).size(); j ++){
                if (i == 0 && j == 0){
                    continue;
                }
                int up = 0;
                int upLeft = 0;
                boolean hasUp = false;
                boolean hasLeft = false;
                if (i - 1 >= 0 && j < triangle.get(i - 1).size()){
                    up = dp[i - 1][j];
                    hasUp = true;
                }
                if (i - 1 >= 0 && j - 1 >= 0 && j - 1 < triangle.get(i - 1).size()){
                    upLeft = dp[i - 1][j - 1];
                    hasLeft = true;
                }

                if (hasUp && hasLeft){
                    dp[i][j] = Math.min(up + triangle.get(i).get(j), upLeft + triangle.get(i).get(j));
                }else if (hasUp && !hasLeft){
                    dp[i][j] = up + triangle.get(i).get(j);
                }else if (!hasUp && hasLeft){
                    dp[i][j] = upLeft + triangle.get(i).get(j);
                }else if (!hasLeft && !hasUp){
                    dp[i][j] = triangle.get(i).get(j);
                }
            }
        }

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i ++){
            if (minResult >= dp[dp.length - 1][i]){
                minResult = dp[dp.length - 1][i];
            }
        }
        return minResult;
    }
}
