/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //方法一：暴力破解, 时间复杂度>O(n^3)，理论上可以暴力法做出这道题，但是leetcode上提交直接超出时间限制。所以放弃这方法
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
                        boolean flag = false;
                        for (List<Integer> item : res) {
                            if (equalList(item, tmp)) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                            res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    private boolean equalList(List<Integer> l1, List<Integer> l2) {
        if (l1.size() != l2.size())
            return false;

        for (Object o : l1) {
            if (!l2.contains(o))
                return false;
        }
        for (Object o : l2) {
            if (!l1.contains(o))
                return false;
        }

        return  true;
    }
}
