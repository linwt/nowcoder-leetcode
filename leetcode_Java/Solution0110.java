// 110. 平衡二叉树


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
剑指offer 39.平衡二叉树
1、本题需要两个递归方法，一个是递归计算每个节点的深度，一个是递归判断每个节点是否平衡
2、递归计算节点深度
  1）方法功能：入参是一个节点，返回该节点的深度
  2）终止条件：节点为空时返回0
  3）递归逻辑：左右节点同样需要计算深度，因此调用同样的方法
  4）返回值：节点的深度 = 1 + max(左节点深度, 右节点深度)
3、递归判断每个节点是否平衡
  1）方法功能：入参是一个节点，返回该节点的左右子树是否平衡
  2）终止条件：节点为空时返回true
  3）递归逻辑：调用计算深度的方法得到左右节点的深度，计算高度差是否不超过1，是则平衡返回true，否则不平衡返回false。左右节点同样需要判断是否平衡，因此调用同样的方法
  4）返回值：
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }
}