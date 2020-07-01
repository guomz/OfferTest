package com.guomz.OfferTest.find_length;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {

        int A[] = {1,2,3,2,1};
        int B[] = {3,2,1,4,7};
        System.out.println(findLengthVer2(A, B));
    }

    /**
     * 暴力解法，时间复杂度立方不可取
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        if (A == null || B == null){
            return 0;
        }
        if (A.length == 0 || B.length == 0){
            return 0;
        }

        int longArr[];
        int shortArr[];
        if (A.length > B.length){
            longArr = A;
            shortArr = B;
        }else {
            longArr = B;
            shortArr = A;
        }

        int maxLength = 0;
        for (int i = 0; i < shortArr.length; i ++){
            if (shortArr.length - 1 <= maxLength){
                return maxLength;
            }
            for (int j = 0; j < longArr.length; j ++){
                if (shortArr[i] == longArr[j]){
                    int m = i;
                    int n = j;
                    int tempLength = 0;
                    while (m < shortArr.length && n < longArr.length && shortArr[m] == longArr[n]){
                        tempLength ++;
                        m ++;
                        n ++;
                    }
                    maxLength = Math.max(maxLength, tempLength);
                }
            }
        }
        return maxLength;
    }

    /**
     * 动态规划思路，设立一个二维数组，两维分别对应两个数组的长度
     * 当Ai与Bj相同时，二维数组对应的arr[i][j]为arr[i-1][j-1]的值加一
     * 最后找出二维数组中最大元素即可，时间复杂度为两个数组长度的乘积
     * 这个方法保证每两个元素只会被比较一次
     * @param A
     * @param B
     * @return
     */
    public static int findLengthVer2(int[] A, int[] B){

        if (A == null || B == null){
            return 0;
        }
        if (A.length == 0 || B.length == 0){
            return 0;
        }

        int longArr[];
        int shortArr[];
        if (A.length > B.length){
            longArr = A;
            shortArr = B;
        }else {
            longArr = B;
            shortArr = A;
        }

        int maxLength = 0;
        int arr[][] = new int[shortArr.length][longArr.length];
        for (int i = 0; i < shortArr.length; i ++){
            for (int j = 0; j < longArr.length; j ++){
                if (shortArr[i] == longArr[j]){
                    if (i > 0 && j > 0){
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }else {
                        arr[i][j] = 1;
                    }
                    maxLength = Math.max(maxLength, arr[i][j]);
                }
            }
        }
        return maxLength;
    }
}
