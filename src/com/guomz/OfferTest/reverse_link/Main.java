package com.guomz.OfferTest.reverse_link;

/**
 * 链表反转
 */
public class Main {

    public static void main(String[] args) {
        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");
        node.next.next.next = new Node("D");
        Node lastNode = node.next.next.next;
        System.out.println(node);
        Node nextNode = null;
        Node preNode = node;

        while (node != null){
            preNode = node.next;
            node.next = nextNode;
            nextNode = node;
            node = preNode;
        }
        System.out.println(lastNode);
    }
}
