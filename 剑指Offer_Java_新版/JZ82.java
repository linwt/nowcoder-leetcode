// 82. 二叉树中和为某一值的路径(一)


/*
递归：
1、终止条件：节点为空，说明没找到，返回false
2、函数作用：累减目标值，判断 目标值是否为0 且 是否为叶结点，若是说明找到符合条件的路径，返回true。否则继续往下判断左右子节点
3、左右子节点需要同样的操作，调用同样的方法实现，只有找到一个符合条件即可，所以用或条件
 */
public class Solution {
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}