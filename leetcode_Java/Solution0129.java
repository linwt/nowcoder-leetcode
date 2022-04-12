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
递归，深度优先搜索：
1、递归思路：自顶向下计算每个节点“产生的数字”，直到叶子结点才是最终有效的目标数字，再将叶子结点的有效数字 自底向上累加得到所有路径的数字之和
2、方法功能：入参是当前节点、父节点“产生的数字”，返回当前节点的数字之和（经过当前节点的路径的数字之和）
3、终止条件：节点为空时返回0
4、递归逻辑：
  1）计算根节点到达当前节点时“产生的数字” = 父节点“产生的数字” * 10 + 当前节点值
  2）如果当前节点没有子节点，那么当前节点的数字之和 就是“产生的数字”，直接返回该结果
  2）如果当前节点有子节点，那么当前节点的数字之和 就是左右节点“产生的数字”的和。左右节点同样需要计算“产生的数字”，因此调用同样的方法，接收到返回值后相加
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


/*
广度优先搜索：
1、使用两个队列，一个存放节点，一个存放根节点到达该节点时“产生的数字”，两个队列一一对应
2、层序遍历，遍历当前层时，把下一层的节点和“产生的数字”存入队列
3、到达叶子结点时才将最终“产生的数字”累加到总和中，即将最后一层节点“产生的数字”累加就是根节点到叶节点数字之和
4、否则持续计算到达新节点时“产生的数字”，并将节点与“产生的数字”保存在队列中
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int val = valQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += val;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    valQueue.offer(val * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    valQueue.offer(val * 10 + right.val);
                }
            }
        }
        return sum;
    }
}