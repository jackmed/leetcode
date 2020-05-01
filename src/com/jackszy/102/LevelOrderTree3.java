import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LevelOrderTree3 {
    private Map<Integer, List<Integer>> resMap;
    //方法三： DFS，先搭好返回的结构，然后分层去填充
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        resMap = new HashMap<>();
        dfs(root, 0);
        return resMap.values().stream().collect(Collectors.toList());
    }

    private void dfs(TreeNode root, Integer level) {
        if (root == null)
            return;

        if (resMap.size() < level+1) {
            List<Integer> tmp = new ArrayList<>();
            resMap.put(level, tmp);
        }
        resMap.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
