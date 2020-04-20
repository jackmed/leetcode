import java.util.List;

public class IsValidBST2 {
    private TreeNode prev;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(new IsValidBST2().isValidBST(root));
    }

    //方法二：中序遍历，得到的应该是一个递增的序列，时间复杂度O(N)，因为用到了递归，空间复杂度O(logN)
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return isValid(root);
    }

    private boolean isValid(TreeNode root) {
        if (root == null)
            return true;

        if (!isValid(root.left))
            return false;

        if (prev != null && prev.val >= root.val)
            return false;

        prev = root;
        return isValid(root.right);
    }
}
