package com.guomz.OfferTest.min_sub_array_len;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(0, nums));
        System.out.println(slideWindowMethod(0, nums));
    }

    /**
     * 比较直接暴力的方法
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++){
            int tempSum = 0;
            int tempLength = 0;
            for (int j = i; j >=0; j --){
                tempSum = tempSum + nums[j];
                tempLength ++;
                if (tempSum < s && tempLength >= minLength){
                    break;
                }
                if (tempSum >= s && tempLength <= minLength){
                    minLength = tempLength;
                    break;
                }
            }
        }

        if (minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }

    /**
     * 动态窗口方法
     * 双指针为窗口边界，当窗口内和小于s，右指针右移；大于等于s，左指针右移右指针不动
     * @param s
     * @param nums
     * @return
     */
    public static int slideWindowMethod(int s, int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;
        int end = 0;
        for (; end < nums.length;){
            windowSum += nums[end];
            if (windowSum >= s){
                minLength = Math.min(minLength, end - start + 1);
                if (minLength == 1){
                    return 1;
                }
                windowSum = windowSum - nums[start];
                windowSum = windowSum - nums[end];
                start ++;
            }else {
                end ++;
            }
        }

        if (minLength == Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}
