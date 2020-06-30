package com.guomz.OfferTest.find_kth_largest;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums[] = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
        System.out.println(findKthLargestVer2(nums, 4));
    }

    /**
     * 先排序后查找
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 采用快排切分的方式查找
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestVer2(int nums[], int k){
        int target = nums.length - k;
        int start= 0;
        int end = nums.length - 1;
        int flag = partition(nums, start, end);
        while (true){
            if (flag > target){
                end = flag - 1;
                flag = partition(nums, start, end);
            }else if (flag < target){
                start = flag + 1;
                flag = partition(nums, start, end);
            }else {
                return nums[flag];
            }
        }
    }

    private static int partition(int nums[], int start, int end){
        int flag = start;
        int i = start + 1;
        int j = end;
        while (true){
            while (i <= end && nums[i] <= nums[flag]){
                i ++;
            }
            while (j >= start && nums[j] > nums[flag]){
                j --;
            }
            if (i >= j){
                int temp = nums[flag];
                nums[flag] = nums[j];
                nums[j] = temp;
                return j;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
