public class MaxDepth2 {
    //方法二：递归分治， divide and conquer
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}
