package com.guomz.OfferTest.flatten;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(6);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            return;
        }

        List<TreeNode> nodeList = new LinkedList<>();
        TreeNode node = root;
        preOrder(node, nodeList);
        node = root;
        for (TreeNode tempNode: nodeList){
            node.left = null;
            node.right = tempNode;
            node = node.right;
        }
        System.out.println(root);
    }

    private static void preOrder(TreeNode node, List<TreeNode> nodeList){
        while (node != null){
            nodeList.add(node);
            preOrder(node.left, nodeList);
            preOrder(node.right, nodeList);
            return;
        }
    }
}
