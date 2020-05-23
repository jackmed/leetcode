import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 22. 括号生成
 * 难度
 * 中等
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {

    private List<String> list;

    public static void main(String[] args) {
        List<String> strings = new GenerateParenthesis().generateParenthesis(4);
        strings.forEach(System.out::println);
    }

    //方法一：递归剪枝

    /**
     * n定了，说明'('和')'的数量也定了，都是n。各自有n个配比。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generateOneByOne(n, n, "");
        return list;
    }

    private void generateOneByOne(int leftUnused, int rightUnused, String resulst) {
        if (leftUnused == 0 && rightUnused == 0) {
            list.add(resulst);
            return;
        }

        if (leftUnused > 0)
            generateOneByOne(leftUnused - 1, rightUnused, resulst + "(");

        if (rightUnused > leftUnused)
            generateOneByOne(leftUnused, rightUnused - 1, resulst + ")");
    }
}
