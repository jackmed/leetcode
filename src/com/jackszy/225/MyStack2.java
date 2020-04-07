import java.util.ArrayDeque;
import java.util.Queue;

////双队列法2：push为O(n)，pop为O(1)
public class MyStack2 {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     * 每次push时候用q2，做辅助队列，把 q1排成stack的顺序
     */
    public void push(int x) {
        q2.add(x);
        top = x;
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> tmp = q2;
        q2 = q1;
        q1 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int res= q1.remove();
        if (!q1.isEmpty())
            top = q1.peek();
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
