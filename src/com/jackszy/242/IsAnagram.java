import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        //方法一：两个字符串都排序，比较排序后的字符串是否相同, O(nlogn)
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
