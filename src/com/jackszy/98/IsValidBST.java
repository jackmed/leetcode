import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 难度
 * 中等
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        List<TreeNode> res = new IsValidBST().inOrder(root);
        System.out.println(1);
    }

    //方法一：中序遍历，得到的应该是一个递增的序列，时间复杂度2O(N)，空间复杂度O(N)
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        List<TreeNode> res = inOrder(root);
        for(int i=0;i<res.size()-1;i++) {
            if (res.get(i).val >= res.get(i+1).val)
                return false;
        }
        return true;
    }

    private List<TreeNode> inOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<TreeNode> res = new ArrayList<>();
        res.addAll(inOrder(root.left));
        res.add(root);
        res.addAll(inOrder(root.right));
        return res;
    }
}
