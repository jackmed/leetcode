import java.util.*;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    public static void main(String[] args) {

    }

    //栈实现
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        //用作栈
        ArrayDeque<Character> deque = new ArrayDeque<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++)
            if (!map.containsKey(s.charAt(i)))
                deque.addLast(s.charAt(i));
            else if (deque.isEmpty() || deque.removeLast() != map.get(s.charAt(i)))
                return false;

        return deque.isEmpty();
    }
}
