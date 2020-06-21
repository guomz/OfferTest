package com.guomz.OfferTest.reverse_link;

public class Node {

    Node next;
    String value;
    public Node(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value='" + value + '\'' +
                '}';
    }
}
