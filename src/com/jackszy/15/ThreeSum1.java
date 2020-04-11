import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreeSum1 {
    //方法二： set去重，  遍历a,b，再去map中找(-a-b)， O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3)
            return Collections.emptyList();

        Arrays.sort(nums);
        int N = nums.length;
        HashSet<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (i>=1 && nums[i] == nums[i-1])
                continue;

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < N; j++) {
                if (!map.containsKey(-nums[i] - nums[j]))
                    map.put(nums[j], 1);
                else {
                    //set去重, list的hashcode是跟list中所有元素有关，list中元素内容相同，则list的hash相同(跟元素顺序无关)
                    List<Integer> tmp = Arrays.asList(new Integer[]{nums[i], nums[j], -nums[i]-nums[j]});
                    res.add(tmp);
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }
}
