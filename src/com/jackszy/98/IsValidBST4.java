public class IsValidBST4 {
    //方法四：递归，根据二叉搜索树的定义，比较当前值和上下边界

    /**
     * 这个方法最直观简洁，性能也好
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val<= min) return false;
        if (max != null && root.val>= max) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
