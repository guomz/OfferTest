package com.guomz.OfferTest.is_balanced;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

public class Main2 {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root){
        return checkDepth(root, 0) > -1;
    }

    /**
     * 使用后续遍历来自底向上遍历节点并同时计算深度，避免重复遍历节点
     * @param node
     * @param depth
     * @return
     */
    private static int checkDepth(TreeNode node, int depth){
        if (node == null){
            return 0;
        }

        int leftDepth = checkDepth(node.left, 0);
        int rightDepth = checkDepth(node.right, 0);
        //如果两边不平衡直接返回-1
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }

        return depth + Math.max(leftDepth + 1, rightDepth + 1);
    }
}
