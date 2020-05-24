import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 52. N皇后 II
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
 */
public class NQueensII {
    private int SIZE;
    private int[] queenPositions;
    private int cnt;

    public int totalNQueens(int n) {
        if (n == 1)
            return 1;
        if (n == 2 || n == 3)
            return 0;

        SIZE = n;
        queenPositions = new int[SIZE];
        cnt = 0;

        search(0);
        return cnt;
    }

    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            //检测是否同列，检测左上，检测右上
            if (queenPositions[row - i] == column || queenPositions[row - i] == column - i || queenPositions[row - i] == column + i)
                return false;
        }

        return true;
    }

    private void search(int row) {
        if (row == SIZE) {
            cnt++;
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            queenPositions[row] = i;
            if (isValid(row, i))
                search(row + 1);
        }
    }

}
