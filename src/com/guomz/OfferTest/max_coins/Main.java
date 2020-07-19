package com.guomz.OfferTest.max_coins;

import java.util.Arrays;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int arr[] = new int[n + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = 1;
        arr[arr.length - 1] = 1;

        int dp[][] = new int[nums.length + 2][nums.length + 2];
        for (int i = 0; i < dp.length; i ++){
            Arrays.fill(dp[i], -1);
        }

        return solve(dp, arr,0, n + 1);
    }

    /**
     * 我们观察戳气球的操作，发现这会导致两个气球从不相邻变成相邻，使得后续操作难以处理。于是我们倒过来看这些操作，将全过程看作是每次添加一个气球。
     *
     * 我们定义方法 \textit{solve}solve，令 \textit{solve}(i,j)solve(i,j) 表示将开区间 (i,j)(i,j) 内的位置全部填满气球能够得到的最多硬币数。由于是开区间，因此区间两端的气球的编号就是 ii 和 jj，对应着 \textit{val}[i]val[i] 和 \textit{val}[j]val[j]。
     *
     * 当 i \geq j-1i≥j−1 时，开区间中没有气球，\textit{solve}(i,j)solve(i,j) 的值为 00；
     *
     * 当 i < j-1i<j−1 时，我们枚举开区间 (i,j)(i,j) 内的全部位置 \textit{mid}mid，令 \textit{mid}mid 为当前区间第一个添加的气球，该操作能得到的硬币数为 \textit{val}[i] \times \textit{val}[\textit{mid}] \times val[j]val[i]×val[mid]×val[j]。同时我们递归地计算分割出的两区间对 \textit{solve}(i,j)solve(i,j) 的贡献，这三项之和的最大值，即为 \textit{solve}(i,j)solve(i,j) 的值。这样问题就转化为求 \textit{solve}(i,\textit{mid})solve(i,mid) 和 \textit{solve}(\textit{mid},j)solve(mid,j) ，可以写出方程：
     *
     * \textit{solve}(i,j)= \begin{cases}{} \displaystyle \max_{\textit{mid} = i + 1}^{j - 1}val[i] \times \textit{val}[\textit{mid}] \times \textit{val}[j] + \textit{solve}(i, \textit{mid}) + \textit{solve}(\textit{mid}, j) ,&i < j - 1 \\ 0, & i \geq j - 1 \end{cases}
     * solve(i,j)=
     * ⎩
     * ⎨
     * ⎧
     * ​
     *
     * mid=i+1
     * max
     * j−1
     * ​
     *  val[i]×val[mid]×val[j]+solve(i,mid)+solve(mid,j),
     * 0,
     * ​
     *
     * i<j−1
     * i≥j−1
     * ​
     *
     *
     * 为了防止重复计算，我们存储 \textit{solve}solve 的结果，使用记忆化搜索的方法优化时间复杂度。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param dp
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int solve(int dp[][], int arr[], int left, int right){
        if (left >= right - 1){
            return 0;
        }
        if (dp[left][right] != -1){
            return dp[left][right];
        }

        for (int i = left + 1; i <= right - 1; i ++){
            int value = arr[left] * arr[i] * arr[right];
            int sum = solve(dp, arr, left, i) + value + solve(dp, arr, i, right);
            dp[left][right] = Math.max(dp[left][right], sum);
        }
        return dp[left][right];
    }
}
