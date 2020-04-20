import java.util.Stack;

public class IsValidBST3 {
    Stack<TreeNode> stack = new Stack<>();
    Double inOrderVal = -Double.MAX_VALUE;

    //方法三：中序遍历的另外一种形式，显示用到栈，深度优先遍历
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    private boolean isValid(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inOrderVal)
                return false;

            inOrderVal = (double)root.val;
            root = root.right;
        }

        return true;
    }
}
