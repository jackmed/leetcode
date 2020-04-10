import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        new TwoSum1().twoSum(nums, target);
    }
    //方法二：a+b=y可以得到 b=y-a，利用map来查找，两遍遍历, O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++)
            if (map.containsKey(target - nums[i]) && map.get(target-nums[i]) != i)
                return new int[]{i, map.get(target - nums[i])};

        return new int[1];
    }
}
