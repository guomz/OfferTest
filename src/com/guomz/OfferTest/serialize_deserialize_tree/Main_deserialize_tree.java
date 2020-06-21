package com.guomz.OfferTest.serialize_deserialize_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 反序列化二叉树
 * 将序列化的先序结果回溯
 */
public class Main_deserialize_tree {

    public static void main(String[] args) {
        deserialize("1,2,null,null,3,4,null,null,null");
    }

    public static TreeNode deserialize(String data){
        if (data == null || data.trim().equals("")){
            return null;
        }
        String arr[] = data.split(",");
        if (arr[0].equals("null")){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        Arrays.stream(arr).forEach(str -> {
            queue.offer(str);
        });
        TreeNode node = buildTree(queue);
        System.out.println(node);
        return node;
    }

    public static TreeNode buildTree(Queue<String> queue){
        while (!queue.isEmpty()){
            String valStr = queue.poll();
            if (valStr.equals("null")){
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(valStr));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
        return null;
    }
}
