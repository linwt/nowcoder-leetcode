// 84. 二叉树中和为某一值的路径(三)


/*
两层递归：
第一个递归 dfs 用于计算从某个结点开始往下产生的路径结点值和为sum的路径数
第二个递归 FindPath 用于遍历每个节点开始的路径数
 */
public class Solution {
    private int res = 0;

    public int FindPath (TreeNode root, int sum) {
        if (root != null) {
            dfs(root, sum);
            FindPath(root.left, sum);
            FindPath(root.right, sum);
        }
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        if (target == 0) {
            res += 1;
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }
}