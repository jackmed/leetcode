import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxSlidingWindow2 {

    //方法二：暴力解法，窗口每移动一位，都比较窗口中的最大值, O(nk)
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++)
            deque.addLast(nums[i]);
        res.add(deque.stream().max(Integer::compareTo).get());
        for(int i=k;i<nums.length;i++) {
            deque.removeFirst();
            deque.addLast(nums[i]);
            res.add(deque.stream().max(Integer::compareTo).get());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
