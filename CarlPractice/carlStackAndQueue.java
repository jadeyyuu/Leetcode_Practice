package CarlPractice;

import java.util.*;

/**
 * 队列是先进先出，栈是先进后出。
 */
public class carlStackAndQueue {

}
/**
 * 232. 用栈实现队列
 * Link: https://leetcode.cn/problems/implement-queue-using-stacks/
 */
class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

}

/**
 * 225. 用队列实现栈
 * Link: https://leetcode.cn/problems/implement-stack-using-queues/
 */
class MyStack {
    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
            Queue<Integer> queueTemp;
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}


