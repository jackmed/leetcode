import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum1 {
    //方法二：Map查找， O(N^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return Collections.emptyList();

        int N = nums.length;
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<N;i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for(int j=i+1;j<N;j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int k=j+1;k<N;k++) {
                    if (!map.containsKey(target- nums[i]- nums[j] - nums[k]))
                        map.put(nums[k], 1);
                    else
                        res.add(Arrays.asList(nums[i] , nums[j] , nums[k] , target- nums[i]- nums[j] - nums[k]));
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
}
