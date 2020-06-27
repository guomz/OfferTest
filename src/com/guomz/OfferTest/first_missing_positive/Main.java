package com.guomz.OfferTest.first_missing_positive;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            if (nums[i] <= 0){
                continue;
            }

            int j = treeSet.last() + 1;
            if (j < nums[i]){
                return j;
            }

            if (!treeSet.contains(nums[i])){
                treeSet.add(nums[i]);
            }
        }

        if (nums[nums.length - 1] <= 0){
            return 1;
        }
        else {
            return nums[nums.length - 1] + 1;
        }
    }
}
