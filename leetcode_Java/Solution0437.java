// 437. 路径总和 III


/**
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
递归：
1、计算单个节点的路径数
  1）方法功能：入参是一个节点、目标和，返回节点值等于目标和的个数
  2）终止条件：节点为空时返回0
  3）一个节点处理过程和返回结果：节点值等于目标和 则返回1，否则返回0
  4）递归调用：左右节点同样需要计算个数，因此调用同样的方法递归处理，获取结果。递归参数目标和累减，减去当前节点值，表示以当前节点开始的路径
  5）递归顺序：前序遍历，左右节点的计算需要依赖根节点值，即传参减去根节点值的目标和
  6）使用递归调用结果和返回结果：获取左右节点的个数，全部相加后得到 当前节点开始的路径 且 路径和为targetSum 的路径数
2、计算所有节点的路径数
  1）方法功能：入参是一个节点、目标和，返回 该节点开始的路径 且 路径和为targetSum 的路径数
  2）终止条件：节点为空时返回0
  3）一个节点处理过程和返回结果：直接调用上个递归函数，计算单个节点的路径数，返回该结果
  4）递归调用：左右节点同样需要计算 以其开始的路径 且 路径和为targetSum 的路径数，因此调用同样的方法递归处理，获取结果
  5）递归顺序：前序遍历，实际三者顺序可随意，互不依赖
  6）使用递归调用结果和返回结果：获取根左右的路径数结果，全部相加后得到所有 路径和为targetSum 的路径数
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.val == targetSum) {
            res += 1;
        }
        targetSum -= root.val;
        res += dfs(root.left, targetSum) + dfs(root.right, targetSum);
        return res;
    }
}