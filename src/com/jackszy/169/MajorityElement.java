/**
 * 169. 多数元素
 * 难度
 * 简单
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class MajorityElement {
    //方法一：暴力法，双重循环，但对于大数组性能太差，时间复杂度O(N^2)
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int count=0;
        for(int i=0;i<len;i++) {
            count =0;
            for(int j=0;j<len;j++) {
                if (nums[j] == nums[i])
                    count++;

                if (count>len/2)
                    return nums[i];
            }
        }
        return nums[0];
    }
}
