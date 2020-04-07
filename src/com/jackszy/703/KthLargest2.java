import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//方法二：维护一个大小为k的数组，数组里存放的是前k大的元素。时间复杂度不如方法一
public class KthLargest2 {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest2 kthLargest = new KthLargest2(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    List<Integer> topK;
    int K;

    public KthLargest2(int k, int[] nums) {
        topK = new ArrayList<>();
        this.K = k;
        for(int num: nums)
            add(num);
    }

    public int add(int val) {
        if (topK.size()<K)
            topK.add(val);
        else if (val > topK.get(0)){
            topK.remove(0);
            topK.add(val);
        }

        Collections.sort(topK);
        return topK.get(0);
    }
}
