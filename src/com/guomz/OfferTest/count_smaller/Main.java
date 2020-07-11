package com.guomz.OfferTest.count_smaller;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {-1, -1};
        System.out.println(countSmaller(nums));
    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null){
            return null;
        }
        if (nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i ++){
            list.add(0);
        }
        for (int i = nums.length - 2; i >= 0; i --){
            int index = partition(nums, i, nums.length - 1);
            list.set(i, index - i);
        }
        return list;
    }

    private static int partition(int nums[], int start, int end){
        int flag = nums[start];
        int i = start + 1;
        int j = end;
        while (true){
            while (i < end && nums[i] < flag){
                i ++;
            }
            while (j > start && nums[j] >= flag){
                j --;
            }

            if (i >= j){
                int temp = nums[j];
                nums[j] = flag;
                nums[start] = temp;
                return j;
            }else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
