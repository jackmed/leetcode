public class BSTLowestCommonAncestor2 {
    //方法二：迭代，相比递归空间复杂度要小很多
    //迭代找到第一个让p和q分叉的节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
