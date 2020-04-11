/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        new FourSum().fourSum(nums, target);
    }

    //方法一：暴力法， O(N^4)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return Collections.emptyList();

        int N = nums.length;
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<N-3;i++) {
            if (i>0 && nums[i] == nums[i-1])
                continue;

            for(int j=i+1;j<N-2;j++) {
                for(int k=j+1;k<N-1;k++) {
                    for(int l=k+1;l<N;l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target)
                            res.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]));
                    }
                }
            }
        }

        return res.stream().collect(Collectors.toList());
    }
}
