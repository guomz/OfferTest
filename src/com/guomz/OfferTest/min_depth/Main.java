package com.guomz.OfferTest.min_depth;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        return calcuByDfs(root, 0, Integer.MAX_VALUE);
    }

    /**
     * 深度遍历，计算每个节点左右字数长度并返回最短的
     * @param node
     * @param currentDepth
     * @param minDepth
     * @return
     */
    private static int calcuByDfs(TreeNode node, int currentDepth, int minDepth){
        if (node.left == null && node.right == null){
            minDepth = Math.min(currentDepth + 1, minDepth);
            return minDepth;
        }

        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (node.left != null){
            leftDepth = calcuByDfs(node.left, currentDepth + 1, minDepth);
        }
        if (node.right != null){
            rightDepth = calcuByDfs(node.right, currentDepth + 1, minDepth);
        }
        return Math.min(leftDepth, rightDepth);
    }
}
