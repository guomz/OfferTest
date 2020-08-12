package com.guomz.OfferTest.maximum_sum;

/**
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 *
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 *
 * 注意，删除一个元素后，子数组 不能为空。
 *
 * 请看示例：
 *
 * 示例 1：
 *
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * 示例 2：
 *
 * 输入：arr = [1,-2,-2,3]
 * 输出：3
 * 解释：我们直接选出 [3]，这就是最大和。
 * 示例 3：
 *
 * 输入：arr = [-1,-1,-1,-1]
 * 输出：-1
 * 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
 *      我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{2,1,-2,-5,-2}));
    }

    public static int maximumSum(int[] arr) {

        if(arr == null || arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return arr[0];
        }

        //以arr[i]结尾的子数组，不删除元素
        int dp1[] = new int[arr.length];
        //以arr[i]结尾的子数组，删除某个元素
        int dp2[] = new int[arr.length];

        dp1[0] = arr[0];
        for (int i = 1; i < arr.length; i ++){
            //以arr[i]结尾最大子数组不删除情况为包含arr[i]与只含有arr[i]
            dp1[i] = Math.max(arr[i], dp1[i - 1] + arr[i]);
        }

        dp2[0] = arr[0];
        dp2[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i ++){
            //比较条件为舍弃与不舍弃当前元素
            //由于舍弃当前元素所以不能再删除其他元素，使用dp1
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + arr[i]);
        }

        //最后找出两个数组中所有元素最大的即可
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i ++){
            result = Math.max(result, dp1[i]);
            result = Math.max(result, dp2[i]);
        }
        return result;
    }
}
