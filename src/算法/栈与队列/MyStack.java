package 算法.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李华宪
 * @Description 核心思路：出队：将除最后一个元素外的元素，重新入队
 * @create 2025-01-02 21:26
 */

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        // Queue 是一个接口，不是具体的类，不能实例化
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public Integer pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public Integer top() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        Integer top = queue.poll();
        queue.offer(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

