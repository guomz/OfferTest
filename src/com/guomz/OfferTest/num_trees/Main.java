package com.guomz.OfferTest.num_trees;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    /**
     * 采用递归和分而治之的思想
     * 设长度为n的序列能构成的二叉搜索树个数为dp[n]
     * 能够推断出dp[n] = ∑(dp[i-1]*dp[n-i])，i为序列中的当前节点
     * dp[0]和dp[1]为1
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i ++){
            for (int j = 1; j <= i; j ++){
                dp[i] += dp[j - 1]*dp[i - j];
            }
        }

        return dp[n];
    }
}
