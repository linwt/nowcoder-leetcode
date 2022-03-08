// 543. 二叉树的直径


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
题意：
1、两个结点路径长度，即两个节点之间边的数目
2、二叉树直径长度，即任意两个结点路径长度中的最大值
思路：
1、遍历每个节点，求该节点的左子树和右子树最大深度的和，得到该节点的直径，再比较每个节点的直径，记录最大直径从而得到二叉树直径长度
递归：
1、方法功能：入参是一个节点，节点为空返回0，节点不为空返回1
2、递归逻辑：
    1）左右节点同样可以调用这个方法，得到0或1的结果
    2）每一层，每个节点，调用方法，都得到了0或1的结果
    3）上一层使用下一层的结果，取下一层左右节点结果的最大值，累加到当前层，从而得到二叉树的最大深度
    4）比较 当前节点的直径 和 当前最大直径，保存较大者
 */
class Solution {
    int maxPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxPath;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        maxPath = Math.max(left + right, maxPath);
        return Math.max(left, right) + 1;
    }
}