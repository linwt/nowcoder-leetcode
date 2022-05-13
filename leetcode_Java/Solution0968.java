// 968. 监控二叉树


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
递归
1、方法功能：入参是一个节点，返回该节点的监控状态
           0：该节点无覆盖  1：该节点有摄像头  2：该节点有覆盖
2、终止条件：节点为空时，表示有覆盖，返回2
3、一个节点处理过程和返回结果：节点不为空，表示无覆盖，返回0
4、递归调用：左右节点同样需要获取监控状态，因此调用同样的方法递归处理，获取结果
5、递归顺序：后序遍历，自底向上进行推导，因为尽量让叶子节点的父节点安装摄像头，这样摄像头的数量才是最少的
6、使用递归调用结果和返回结果：
   1）左右节点其中一个无覆盖，那么当前节点需要安装摄像头，用于覆盖子节点，返回1
   2）左右节点其中一个有摄像头，那么当前节点有覆盖，返回2
   3）左右节点都有覆盖，那么当前节点无覆盖，交给当前节点的父节点处理，返回0
   4）根节点无覆盖，根节点没有父节点了，要自己处理，所以要安装摄像头
 */
class Solution {
    private int res = 0;

    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? res + 1 : res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}