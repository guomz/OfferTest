package com.guomz.OfferTest.diving_board;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 *
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(divingBoard(1, 2, 3));
    }

    /**
     * 若长短相同则只有一种长度
     * 否则数组从小到大最小为全部shorter，最长为全longer
     * 之间的元素为将shorter一个个替换为longer
     * 长度每次增加longer-shorter
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[]{};
        }

        if (shorter == longer){
            return new int[]{shorter * k};
        }

        int tempLength = shorter * k;
        int arr[] = new int[k + 1];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = tempLength;
            tempLength += longer - shorter;
        }
        return arr;
    }
}
