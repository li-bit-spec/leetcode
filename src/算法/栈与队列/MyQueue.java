package 算法.栈与队列;

import java.util.Stack;

/**
 * @author 李华宪
 * @Description
 * @create 2025-01-02 21:12
 */
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    // 构造函数，初始化 stack
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 实现入队
    public void push(int x) {
        stackIn.push(x);
    }

    // 实现出队
    public int pop() {
        // 如果 stackIn 为空首先需要把 stackIn 的转入 stackOut
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    // 实现读取队首选素
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    // 实现判断队列是否为空
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
