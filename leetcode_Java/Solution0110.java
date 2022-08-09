// 110. 平衡二叉树
// 解法类似“543. 二叉树的直径”

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
1、本题需要两个递归方法，一个是递归计算每个节点的深度，一个是递归判断每个节点是否平衡。自顶向下
2、递归计算节点深度
  1）方法功能：入参是一个节点，返回该节点的深度
  2）终止条件：节点为空时返回0
  3）递归逻辑：左右节点同样需要计算深度，因此调用同样的方法
  4）返回值：节点的深度 = 1 + max(左节点深度, 右节点深度)
3、递归判断每个节点是否平衡
  1）方法功能：入参是一个节点，返回该节点的左右子树是否平衡
  2）终止条件：节点为空时返回true
  3）递归逻辑：调用计算深度的方法得到左右节点的深度，计算高度差是否不超过1，是则平衡返回true，否则不平衡返回false。左右节点同样需要判断是否平衡，因此调用同样的方法
  4）返回值：节点为根的树是否平衡 且 左节点为根的树是否平衡 且 右节点为根的树是否平衡
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


/*
递归 + 记忆存储：自顶向下
1、计算深度递归函数
  1）方法功能：入参是一个节点，返回节点的深度
  2）终止条件：节点为空时返回0
  3）一个节点处理过程和返回结果：节点不为空时返回1
  4）递归调用：左右节点同样需要计算深度，因此调用同样的方法处理，获取结果
  5）递归顺序：后序遍历，当前节点的深度计算依赖左右节点的深度
  6）使用递归调用结果和返回结果：当前节点的深度 = 1 + max(左节点深度, 右节点深度)
  7）递归结果记忆存储：判断节点是否平衡时，会重复计算节点的深度，使用哈希表存储节点对应的深度 {节点：深度}，重复调用时可直接获取返回
2、判断节点是否平衡
  1）方法功能：入参是一个节点，返回该节点是否平衡
  2）终止条件：节点为空返回true
  3）一个节点处理过程和返回结果：abs(左节点深度 - 右节点深度) <= 1 时，则节点平衡返回true，否则返回false
  4）递归调用：左右节点同样需要判断是否平衡，因此调用同样的方法处理，获取结果
  5）递归顺序：前序遍历，当前节点是否平衡不依赖左右节点是否，三者顺序可随意。可以先判断根节点是否平衡，然后判断左节点是否平衡，最后判断右节点是否平衡
  6）使用递归调用结果和返回结果：二叉树是否平衡 = 根节点是否平衡 && 左节点是否平衡 && 右节点是否平衡
 */
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

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
        if (map.get(root) != null) {
            return map.get(root);
        }
        int depth = 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
        map.put(root, depth);
        return depth;
    }
}


/*
递归 + 平衡标志：自底向上
计算节点深度递归函数：计算深度的同时，利用深度判断是否平衡
1、方法功能：入参是一个节点，返回节点的深度
2、终止条件：节点为空时返回0
3、一个节点处理过程和返回结果：节点不为空时返回1
4、递归调用：左右节点同样需要计算深度，因此调用同样的方法处理，获取结果
5、递归顺序：后序遍历，当前节点的深度计算依赖左右节点的深度
6、使用递归调用结果和返回结果
  1）当前节点的深度 = 1 + max(左节点深度, 右节点深度)
  2）平衡标志flag为true 且 左右节点深度差大于1，则二叉树不平衡，更新成员变量flag为false
 */
class Solution {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (flag && Math.abs(left - right) > 1) {
            flag = false;
        }
        return 1 + Math.max(left, right);
    }
}