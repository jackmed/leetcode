import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MajorityElement2 {
    //方法二：用一个map来把元素次数记下来，时间复杂度O(N)，空间复杂度O(N)
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int i=0;i<len;i++) {
            cntMap.merge(nums[i], 1, Integer::sum);
            if (cntMap.get(nums[i])> len/2)
                return nums[i];
        }
        return nums[0];
    }
}
