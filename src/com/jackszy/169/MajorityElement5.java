import java.util.Arrays;

public class MajorityElement5 {
    //方法五：分治法。 divie & conquer，时间复杂度为O(NlogN)
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length-1);
    }

    private int majorityElement(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];

        int mid = low+(high-low)/2;
        int left = majorityElement(arr, low, mid);
        int right = majorityElement(arr, mid+1, high);
        if (left == right)
            return left;

        int cntL = count(arr, left);
        int cntR = count(arr, right);
        return cntL > cntR ? left : right;
    }

    private int count(int[] nums, int a) {
        int count = 0;
        for (int i : nums)
            if (i == a)
                count++;

        return count;
    }
}
