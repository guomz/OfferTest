package com.guomz.OfferTest.serialize_deserialize_tree;

/**
 * 序列化输出二叉树
 * 用先序遍历序列化输出
 */
public class Main_serialize {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);

        System.out.println(serialize(node));
    }

    public static String serialize(TreeNode root){
        if (root == null){
            return "";
        }
        StringBuilder resultStr = new StringBuilder();
        preOrder(root, resultStr);
        return resultStr.replace(resultStr.length() - 1, resultStr.length(), "").toString();
    }

    public static void preOrder(TreeNode node, StringBuilder resultStr){
        while (true){
            if (node == null){
                resultStr.append("null,");
                return;
            }
            resultStr.append(node.val + ",");
            preOrder(node.left, resultStr);
            preOrder(node.right,resultStr);
            return;
        }
    }
}
