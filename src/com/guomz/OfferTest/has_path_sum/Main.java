package com.guomz.OfferTest.has_path_sum;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return findSum(root, sum, 0);
    }

    /**
     * 递归解法
     * @param node
     * @param sum
     * @param currentSum
     * @return
     */
    private static boolean findSum(TreeNode node, int sum, int currentSum){
        if (node == null){
            return false;
        }

        currentSum += node.val;
        if (node.left == null && node.right == null){
            if (currentSum == sum){
                return true;
            }
            return false;
        }
        return findSum(node.left, sum, currentSum) || findSum(node.right, sum, currentSum);
    }
}
