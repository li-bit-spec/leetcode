package 算法.链表;

/**
 * @author 李华宪
 * @Description
 * @create 2025-03-05 21:58
 */

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head, tail;

    // 由三部分组成
    // 1. 容量
    // 2. 快速查找节点的HashMap
    // 3. 自己构建的一个双向链表，起始包含一个伪头结点和一个伪尾结点，并组成链表
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // head 和 tail 初始化为 dummy node，方便操作，链表初始状态是 head -> tail
        // 方便定位真正的头节点和尾节点
        head = new Node(-1, -1); // 伪头结点
        tail = new Node(-1, -1); // 伪尾结点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // 将该节点移动到头部
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // 如果key 存在: 更新node 的 value，并移动到头部
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // 如果key不存在，如果 cache 满容量（虽然 cache hashmap 是定位用的，但是链表的长度应该 = cache 的长度）
            // 先删除尾元素，再添加头元素
            if (cache.size() == capacity) {
                removeTail();
                Node node = new Node(key, value);
                cache.put(key, node);
                addToHead(node);
            }
        }

    }

    private void moveToHead(Node node) {
        // 先删除该节点
        removeNode(node);
        // 再将该节点加入头部
        addToHead(node);
    }

    private void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    // 不仅仅是删除尾节点
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 删除尾节点
    private void removeTail() {
        Node last = tail.prev;
        removeNode(last); // 从链表中删除
        cache.remove(last.key);
    }

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}

