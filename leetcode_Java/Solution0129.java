// 129. 求根节点到叶节点数字之和


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
递归，自顶向下计算：
1、方法功能：入参是节点、前面的数字之和，返回根节点到达当前节点时的数字之和
2、终止条件：节点为空时返回0
3、递归逻辑：根节点到达当前节点时的数字之和 = 前面的数字之和 * 10 + 当前节点值，返回该结果。由于左右节点同样需要计算数字之和，因此调用同样的方法
4、返回结果：节点的左右节点都为空时，返回该节点的数字之和。否则计算左右节点的数字之和，两者相加然后返回。
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

}