package com.guomz.OfferTest.maxScoreSightseeingPair;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 本质上可以用背包策略解决，关键在于要将得分公式分为两部分求解即Ai + i与Aj + j
 */
public class Main {

    public static void main(String[] args) {
        int A[] = {8,1,5,2,6};
        getMaxScore(A);
    }

    public static int getMaxScore(int[] A){
        int maxScore = 0;
        int maxHalfScore = 0;
        for (int i = 1; i < A.length; i ++){
            int tempHalf = i - 1 + A[i - 1];
            if (tempHalf >= maxHalfScore){
                maxHalfScore = tempHalf;
            }
            int tempScore = maxHalfScore + A[i] - i;
            if (tempScore >= maxScore){
                maxScore = tempScore;
            }
        }
        System.out.println(maxScore);
        return maxScore;
    }
}

