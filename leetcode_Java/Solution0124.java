// 124. 二叉树中的最大路径和


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/*
递归：
1、方法功能：入参是一个节点，返回该节点给父节点的贡献值
2、终止条件：空节点时返回0
3、单层递归逻辑：
  1）调用递归方法得到左节点、右节点的贡献值
  2）计算当前节点为路径根节点时的最大路径和，并更新最大结果。最大路径和 = 根节点值 + 左节点值 + 右节点值
  3）计算当前节点给父节点的贡献值，若为负数则记为0，并返回贡献值。贡献值 = max(0, 根+左, 根+右)
 */
class Solution {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, root.val + left + right);
        return Math.max(0, Math.max(root.val + left, root.val + right));
    }
}