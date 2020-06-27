package com.guomz.OfferTest.remove_dupilate_node;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        System.out.println(removeDuplicateNodes(node));
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> valSet = new HashSet<>();
        ListNode currentNode = head;
        ListNode preNode = null;
        while (currentNode != null){
            if (!valSet.contains(currentNode.val)){
                valSet.add(currentNode.val);
                preNode = currentNode;
                currentNode = currentNode.next;
            }else {
                preNode.next = currentNode.next;
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
