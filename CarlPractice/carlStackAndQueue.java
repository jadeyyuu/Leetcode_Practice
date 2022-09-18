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

/**
 * 20. 有效的括号
 * Link: https://leetcode.cn/problems/valid-parentheses/
 */
class isValid20 {
    public boolean isValid(String s) {
        // 注意到有效字符串的长度一定为偶数，省去后续的遍历判断过程。
        int n = s.length();
        if (n % 2 == 1) return false;

        // 新建一个双端队列函数，
        // 既可以添加到队尾，也可以添加到队首；
        // 既可以从队首获取，又可以从队尾获取。
        Deque<Character> deque = new LinkedList<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) { // peek 取队首元素但不删除
                return false;
            } else{
                deque.pop(); //如果是右括号判断是否和栈顶元素匹配
            }
        }
        return deque.isEmpty();
    }
}

