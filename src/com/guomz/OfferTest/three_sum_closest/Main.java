package com.guomz.OfferTest.three_sum_closest;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {1,2,5,10,11};
        System.out.println(threeSumClosest(nums, 12));
    }

    /**
     * 先排序，之后遍历每个元素
     * 然后采用双指针指向当前元素下一个与末尾元素，比较双指针的和与target减去当前元素的差值
     * 若双指针和要大，则右指针左移，否则左指针右移(类似二分法)
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int nums[], int target){
        Arrays.sort(nums);
        int threeSumResult = 0;
        int threeSumMinusResult = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++){
            int j = i + 1;
            int k = nums.length - 1;
            if (j >= k){
                break;
            }
            int sum = target - nums[i];
            int twoSum = findMinResult(nums, sum, j, k);
            if (twoSum == sum){
                return target;
            }

            if (Math.abs(target - nums[i] - twoSum) <= threeSumMinusResult){
                threeSumMinusResult = Math.abs(target - nums[i] - twoSum);
                threeSumResult = nums[i] + twoSum;
            }
        }
        return threeSumResult;
    }

    private static int findMinResult(int nums[], int sum, int j, int k){
        int sumMinus = Integer.MAX_VALUE;
        int nowSum = 0;
        while (j < k){
             int tempSum = nums[j] + nums[k];
             int tempMinus = Math.abs(sum - tempSum);
             if (tempMinus <= sumMinus){
                 sumMinus = tempMinus;
                 nowSum = tempSum;
             }
            if (tempSum <= sum){
                j ++;
            }else{
                k--;
            }
        }
        return nowSum;
    }
}
