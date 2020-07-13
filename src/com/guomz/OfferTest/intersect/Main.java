package com.guomz.OfferTest.intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {1,1};
        intersect(nums1, nums2);
    }

    /**
     * 使用类似归并排序的方法对两个数组进行比较
     * 先对两个数组进行排序
     * 之后双指针比较两个数组的每个元素
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return null;
        }
        if (nums1 != null && nums1.length == 0){
            return new int[0];
        }
        if (nums2 != null && nums2.length == 0){
            return new int[0];
        }

        int shortArr[];
        int longArr[];
        if (nums1.length > nums2.length){
            longArr = nums1;
            shortArr = nums2;
        }else {
            longArr = nums2;
            shortArr = nums1;
        }
        Arrays.sort(longArr);
        Arrays.sort(shortArr);
        List<Integer> resultList = new ArrayList<>(shortArr.length);
        int i = 0, j = 0;
        while (true){
            while (j < shortArr.length && i < longArr.length && longArr[i] < shortArr[j]){
                i ++;
            }
            while (j < shortArr.length && i < longArr.length && shortArr[j] < longArr[i]){
                j ++;
            }
            if (!(j < shortArr.length && i < longArr.length)){
                break;
            }
            if (longArr[i] == shortArr[j]){
                resultList.add(shortArr[j]);
                i ++;
                j ++;
                continue;
            }
        }
        int resultArr[] = new int[resultList.size()];
        for (int k = 0; k < resultArr.length; k ++){
            resultArr[k] = resultList.get(k);
        }
        return resultArr;
    }
}
