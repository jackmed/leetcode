import java.util.ArrayDeque;
import java.util.Queue;

//单队列法：push为O(n)，pop为O(1)
public class MyStack3 {
    Queue<Integer> q1;

    /**
     * Initialize your data structure here.
     */
    public MyStack3() {
        q1 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     * 每当入队一个新元素的时候，我们可以把队列的顺序反转过来
     * 顺序入队，逆序存储，达到后进先出的效果。
     */
    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
