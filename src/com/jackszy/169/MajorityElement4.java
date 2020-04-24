import java.util.Arrays;

public class MajorityElement4 {
    //方法四：先把数组排序，然后n/2位置的元素一定是多数元素
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
