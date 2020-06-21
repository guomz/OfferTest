package com.guomz.OfferTest.recover_from_preorder_tree;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        TreeNode root = recoverFromPreorder("1-2--3--4-5--6--7");
        String str = printByLevel(root);
        System.out.println();
        System.out.println(str);
    }
    //用于保存需要回到的某个父节点，从而构建右子树
    static int jumpLevel = 0;
    public static TreeNode recoverFromPreorder(String S) {
        if (S == null || S.equals("")){
            System.out.println("");
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean isEnd = false;
        //将字符串中的节点与线段放入队列，需要处理节点为多位数的情况
        for (int i = 0; i < S.length();){
            if (S.charAt(i) == '-'){
                queue.offer(S.charAt(i) + "");
                i ++;
                continue;
            }
            for (int j = i; j < S.length(); j ++){
                if (S.charAt(j) == '-'){
                    queue.offer(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    i = j;
                    break;
                }
                stringBuilder = stringBuilder.append(S.charAt(j));
                if (j == S.length() - 1){
                    isEnd = true;
                    queue.offer(stringBuilder.toString());
                }
            }
            if (isEnd){
                break;
            }
        }

        TreeNode root = buildTree(queue, 0);

        return root;
    }

    private static TreeNode buildTree(Queue<String> queue, int level){
        while (!queue.isEmpty()){
            String valueStr = queue.poll();
            TreeNode node = new TreeNode(Integer.parseInt(valueStr.trim()));
            int nextLevel = 0;
            if (queue.isEmpty()){
                //尾节点情况
                return node;
            }
            //计算下一个节点位于第几层
            while (queue.peek().equals("-")){
                queue.poll();
                nextLevel ++;
            }
            //下一层按照题目要求只会比当前层级大一层或少若干层或相同
            //若下一个节点层级比当前层级大一层，则构建左子树
            if (nextLevel - level == 1){
                node.left = buildTree(queue, nextLevel);
                //如果跃迁层级变量值为当前层级加一则要构建右子树(说明之前的深度遍历到了尽头)
                if (jumpLevel == level + 1){
                    node.right = buildTree(queue, jumpLevel);
                }
            }
            //相同或小于当前层都需要回到对应的父节点构建右子树
            else {
                //保存该右子树位于的层级
                jumpLevel = nextLevel;
                return node;
            }
            return node;
        }
        return null;
    }

    private static String printByLevel(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        while (!onlyNull(queue)){
            TreeNode node = queue.poll();
            if (node == null){
                System.out.print("null,");
                stringBuilder.append("null,");
                continue;
            }
            System.out.print(node.val + ",");
            stringBuilder.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "").toString();
    }

    private static boolean onlyNull(Queue<TreeNode> queue){
        List<TreeNode> treeNodeList = queue.stream().filter(node -> node != null).collect(Collectors.toList());
        if (treeNodeList.isEmpty()){
            return true;
        }
        return false;
    }
}
