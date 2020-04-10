import java.util.HashMap;

public class TwoSum2 {
    //方法三：a+b=y可以得到 b=y-a，利用map来查找，一遍遍历, O(n)，可以处理有重复值的数组
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target- nums[i];
            if (map.containsKey(b))
                return new int[] {i, map.get(b)};

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
