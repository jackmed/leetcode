import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IsAnagram2 {
    public static void main(String[] args) {
        System.out.println(new IsAnagram2().isAnagram("anagram", "nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        //方法二：用map来计数，存放字符串中每个字母出现的次数。O(n)
        HashMap<Character, Integer> sCnt = new HashMap<>();
        HashMap<Character, Integer> tCnt = new HashMap<>();
        for(Character item: s.toCharArray())
            if (sCnt.containsKey(item))
                sCnt.put(item, sCnt.get(item) +1);
            else
                sCnt.put(item, 1);

        for(Character item: t.toCharArray())
            if (tCnt.containsKey(item))
                tCnt.put(item, tCnt.get(item) +1);
            else
                tCnt.put(item, 1);
//            tCnt.merge(item, 1, Integer::sum);

        return sCnt.equals(tCnt);
    }
}
