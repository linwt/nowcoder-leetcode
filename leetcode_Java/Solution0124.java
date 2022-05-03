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
  2）计算当前节点为路径根节点时的最大路径和，并更新最大结果。最大路径和 = 根节点值 + 左节点贡献值 + 右节点贡献值
  3）计算当前节点给父节点的贡献值，若为负数则记为0，并返回贡献值。贡献值 = max(0, 根节点值 + max(左节点贡献值, 右节点贡献值))
=======================================================================================
新注释模板，递归
计算贡献值递归函数
1、方法功能：入参是一个节点，返回该节点的贡献值。贡献值指从该节点出发，向下沿子节点连接的一条路，可获取的最大正收益
2、终止条件：节点为空时返回0
3、一个节点处理过程和返回结果：比较并更新最大路径和 max(res, root.val)，返回节点的贡献值 max(0, root.val)，节点值为负数时贡献值为0
4、递归调用：左右节点同样需要计算贡献值，因此调用同样的方法递归处理，获取结果
5、递归顺序：后序遍历，当前节点的贡献值依赖左右节点的贡献值，因此要先计算左右节点的贡献值
6、使用递归调用结果和返回结果：
  1）当前节点为路径根节点时的最大路径和 = 根节点值 + 左节点贡献值 + 右节点贡献值
  2）当前节点的贡献值 = max(0, 根节点值 + max(左节点贡献值, 右节点贡献值))
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
        return Math.max(0, root.val + Math.max(left, right));
    }
}