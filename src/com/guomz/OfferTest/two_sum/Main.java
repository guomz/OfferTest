package com.guomz.OfferTest.two_sum;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int numbers[] = new int[]{2, 3, 4};
        System.out.println(twoSum(numbers, 6));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2){
            return new int[2];
        }

        int arr[] = new int[2];
        for (int i = 0; i < numbers.length; i ++){
            if (numbers[i] <= target){
                int result = findNum(numbers,i + 1, target - numbers[i]);
                if (result != -1 && result != i){
                    arr[0] = i + 1;
                    arr[1] = result + 1;
                    Arrays.sort(arr);
                    return arr;
                }
            }
        }

        return arr;
    }

    private static int findNum(int numbers[], int start, int num){
        int i = start;
        int j = numbers.length - 1;
        while (i <= j){
            int mid = (j - i)/2 + i;
            if (numbers[mid] == num){
                return mid;
            }else if (numbers[mid] > num){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
