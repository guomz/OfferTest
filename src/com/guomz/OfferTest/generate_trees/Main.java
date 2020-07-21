package com.guomz.OfferTest.generate_trees;

import com.guomz.OfferTest.serialize_deserialize_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }

        return generateTree(1, n);
    }

    /**
     * 利用分治思想，列举出左右子树集合，然后循环组合左右子树构成二叉树
     * @param start
     * @param end
     * @return
     */
    private static List<TreeNode> generateTree(int start, int end){
        List<TreeNode> nodeList = new LinkedList<>();
        if (start > end){
            nodeList.add(null);
            return nodeList;
        }

        for (int i = start; i <= end; i ++){
            List<TreeNode> leftList = generateTree(start, i - 1);
            List<TreeNode> rightList = generateTree(i + 1, end);
            for (TreeNode leftNode: leftList){
                for (TreeNode rightNode: rightList){
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }
}
