public class MaxDepth3 {
    private int max = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new MaxDepth3().maxDepth(root);
    }

    //方法三：DFS，判断是不是叶子节点，是叶子节点就更新最大深度
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 1);
        return max;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            max = level > max ? level : max;
        } else {
            dfs(root.left, level+1);
            dfs(root.right, level+1);
        }
    }
}
