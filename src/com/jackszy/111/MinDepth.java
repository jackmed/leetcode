/**
 * 111. 二叉树的最小深度
 * 难度
 * 简单
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 */
public class MinDepth {
    //方法一：分治
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        if (leftMinDepth == 0 || rightMinDepth ==0)
            return leftMinDepth + rightMinDepth + 1;
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
