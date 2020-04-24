import java.util.Arrays;

public class MajorityElement3 {
    //方法三：先把数组排序，然后遍历元素，可以方便的计算元素的重复次数，时间复杂度O(NlogN)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1;i<nums.length;i++) {
            if (nums[i] == nums[i-1])
                count++;
            else
                count = 1;

            if (count> nums.length/2)
                return nums[i];
        }
        return nums[0];
    }
}
