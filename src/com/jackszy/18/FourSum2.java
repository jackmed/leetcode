import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum2 {
    //方法三：先排序，再用双指针法从两边往中间夹逼， O(N^3)
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
                int l=j+1, r=N-1;
                while (l<r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l++;
                    } else if (sum> target) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i] , nums[j] , nums[l] , nums[r]));
                        while (l<r && nums[l] == nums[l+1])
                            l++;
                        while (l<r && nums[r] == nums[r-1])
                            r--;
                        l++;r--;
                    }
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
}
