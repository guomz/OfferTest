package com.guomz.OfferTest.CQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    private Queue<Integer> stack1;
    private Queue<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.offer(value);
    }

    public int deleteHead() {
        if (stack2.size() == 0){
            while (stack1.size() != 0){
                int value = stack1.poll();
                stack2.offer(value);
            }
        }

        if (stack2.size() == 0){
            return -1;
        }
        return stack2.poll();
    }

    public Queue<Integer> getStack1() {
        return stack1;
    }

    public void setStack1(Queue<Integer> stack1) {
        this.stack1 = stack1;
    }

    public Queue<Integer> getStack2() {
        return stack2;
    }

    public void setStack2(Queue<Integer> stack2) {
        this.stack2 = stack2;
    }
}
