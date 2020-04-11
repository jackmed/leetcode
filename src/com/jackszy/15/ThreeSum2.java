import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum2 {
    //方法三：先排序，再用双指针法从两边往中间夹逼, 时间复杂度O(N^2)，但是空间复杂度为O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return Collections.emptyList();

        int N = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //因为排好序了，所以nums[i]大于0，则后面不存在其他解了
            if (nums[i] > 0)
                break;

            int l = i + 1, r = N - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0)
                    l++;
                else if (sum > 0)
                    r--;
                else {
                    //set去重, list的hashcode是跟list中所有元素有关，list中元素内容相同，则list的hash相同(跟元素顺序无关)
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[l], nums[r]}));
                    while (l < r && nums[l + 1] == nums[l])
                        l++;

                    while (l < r && nums[r - 1] == nums[r])
                        r--;

                    l++;
                    r--;
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
}
