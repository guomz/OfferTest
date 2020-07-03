package com.guomz.OfferTest.sorted_array_to_BST;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * 关键点在于需要利用数组有序这一性质分而治之
     * 整体思路利用递归，由于数组是递增的，所以每次取中间的元素
     * 之后将元素左边和右边分别递归建立左右子树
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = buildBST(nums, 0, nums.length - 1);
        return root;
    }

    /**
     * 当起始位置大于结束位置说明前一个节点在左/右边没有子节点
     * 若起点终点相同则直接返回当前位置
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static TreeNode buildBST(int nums[], int start, int end){
        if (start > end){
            return null;
        }

        if (start == end){
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }
}
