// 112. 路径总和


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
1、方法功能：入参是一个节点，返回该节点值是否等于目标和
2、终止条件：节点为空时返回false
3、返回结果：节点不为空时，如果是叶子结点且节点值等于目标和，则返回true
4、递归逻辑：
  1）没到达叶子结点前，左右节点同样要计算获取结果，再拿结果处理，其中一个为true则返回true
  2）自顶向下累减传递目标和，到叶子结点后，自底向上返回处理结果
===========================================================================
新注释模板，递归
1、方法功能：入参是节点、目标值，判断节点值是否等于目标值，是则返回true，否则返回false
2、终止条件：节点为空时，返回false
3、一个节点处理过程和返回结果：到达叶子结点才作判断，即 左右节点为空 且 节点值等于目标值，是则返回true，否则返回false
4、递归调用：左右节点同样需要判断是否等于目标值，因此调用同样的方法递归处理，获取结果。递归参数目标值累减，减去当前节点值
5、递归顺序：前序遍历，要先判断根节点是否满足，满足则结束返回true，不满足再继续判断左右节点
6、使用递归调用结果和返回结果：左节点满足 或 右节点满足，那么就存在路径和为目标值，返回true，否则返回false
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}


/*
广度优先搜索：
1、层序遍历节点，利用两个队列分别保存 节点 和 到达节点时的路径和
2、当节点是叶子节点时，判断路径和等于目标和则返回true，否则将左右节点与其对应的路径和加入队列中，继续循环处理
3、遍历结束后没有找到目标和则返回false
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer sum = sumQueue.poll();
            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(sum + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(sum + node.right.val);
            }
        }
        return false;
    }
}