/**
 * 111. 二叉树的最小深度
 * 难度
 * 简单
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最小深度  2.
 */
public class MinDepth3 {
    private int min = 1;

    //方法三：DFS, 动态更新最小值
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return min;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (isLeaf(root)) {
            if (min == 1 || level < min)
                min = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
