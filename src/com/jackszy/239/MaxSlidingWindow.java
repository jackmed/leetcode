import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 */

//方法一：维护一个最大堆，时间复杂度O(nlogk)
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if (pq.size()<k) {
                pq.add(nums[i]);
                continue;
            }
            res.add(pq.peek());
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
        }
        res.add(pq.peek());
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
