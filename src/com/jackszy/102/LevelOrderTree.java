import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 难度
 * 中等
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrderTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new LevelOrderTree().levelOrder(root);
    }

    /**
     * 方法一：BFS，先为二叉树的每个元素附加一个level，然后遍历带level的队列，得到最终结果，空间复杂度稍微复杂一点，时间复杂度O(N)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        Queue<Level> queue = new ArrayDeque<>();
        Queue<Level> helperQueue = new ArrayDeque<>();

        queue.add(new Level(root, 0));
        while (!queue.isEmpty()) {
            Level current = queue.remove();
            if (current.getNode() != null) {
                helperQueue.add(current);
                if (current.getNode().left != null)
                    queue.add(new Level(current.getNode().left, current.level + 1));
                if (current.getNode().right != null)
                    queue.add(new Level(current.getNode().right, current.level + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        Integer preLevel = 0;
        List<Integer> tmp = new ArrayList<>();
        while (!helperQueue.isEmpty()) {
            Level curentLevel = helperQueue.remove();
            if (curentLevel.getLevel() > preLevel) {
                res.add(tmp);
                tmp = new ArrayList<>();
                tmp.add(curentLevel.getNode().val);
                preLevel++;
                continue;
            }

            tmp.add(curentLevel.getNode().val);
        }
        if (!tmp.isEmpty())
            res.add(tmp);
        return res;
    }

    class Level {
        private TreeNode node;
        private Integer level;

        public Level(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public Integer getLevel() {
            return level;
        }
    }
}
