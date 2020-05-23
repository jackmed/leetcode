import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 提示：
 * <p>
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 */
public class NQueens {
    private int SIZE;
    private int[] queenPositions;

    public static void main(String[] args) {
        List<List<String>> lists = new NQueens().solveNQueens(5);
        lists.forEach(System.out::println);
    }

    /**
     * 递归的解法：
     * （1）一行一行递归遍历，当 遍历完最后一行时，就表示放置完毕
     * （2) 用一个大小为n的一维数组表示每行皇后放置的位置
     * （3）每次放置时，只需要验证该行这个位置是否和上面的行的皇后位置相冲(剪枝思想)
     * （4）因为要求所有的有效解，所以用到了递归和回溯
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 1)
            return Collections.singletonList(Arrays.asList("Q"));
        if (n == 2 || n == 3)
            return Collections.emptyList();

        SIZE = n;
        queenPositions = new int[SIZE];

        List<List<String>> res = new ArrayList<>();
        search(0, res);
        return res;
    }

    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            //检测是否同列，检测左上，检测右上
            if (queenPositions[row - i] == column || queenPositions[row - i] == column - i || queenPositions[row - i] == column + i)
                return false;
        }

        return true;
    }

    private void search(int row,  List<List<String>> res) {
        if (row == SIZE) {
            res.add(resolvePosition());
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            queenPositions[row] = i;
            if (isValid(row, i))
                search(row + 1, res);
        }
    }

    private List<String> resolvePosition() {
        List<String> res = new ArrayList<>();
        for (int pos : queenPositions) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < SIZE; i++) {
                if (i == pos)
                    tmp.append('Q');
                else
                    tmp.append('.');
            }
            res.add(tmp.toString());
        }

        return res;
    }
}
