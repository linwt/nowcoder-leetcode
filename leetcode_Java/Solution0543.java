// 543. 二叉树的直径
// 解法类似“110. 平衡二叉树”

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
结论：
1、两个结点路径长度，即两个节点之间边的数目
2、某个结点作为根节点的最大路径长度 = 左节点的深度 + 右节点的深度
3、二叉树的直径为 每个节点作为根节点时的最大路径长度中 取最大值

递归 + 最大路径长度成员变量
计算深度递归函数
1、方法功能：入参是一个节，返回节点的深度
2、终止条件：节点为空时返回0
3、一个节点处理过程和返回结果：节点不为空时返回1
4、递归调用：左右节点同样需要计算深度，因此调用同样的方法处理，获取结果
5、递归顺序：后序遍历，当前节点的深度计算依赖左右节点的深度
6、使用递归调用结果和返回结果
  1）当前节点的深度 = 1 + max(左节点深度, 右节点深度)
  2）当前节点为根节点的最大路径长度 = 左节点的深度 + 右节点的深度，更新成员变量最大路径长度maxPath，最终最大值即为直径
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
        return 1 + Math.max(left, right);
    }
}


/*
递归 + 记忆存储：
1、计算深度递归函数
  1）方法功能：入参是一个节点，返回节点的深度
  2）终止条件：节点为空时返回0
  3）一个节点处理过程和返回结果：节点不为空时返回1
  4）递归调用：左右节点同样需要计算深度，因此调用同样的方法处理，获取结果
  5）递归顺序：后序遍历，当前节点的深度计算依赖左右节点的深度
  6）使用递归调用结果和返回结果：当前节点的深度 = 1 + max(左节点深度, 右节点深度)
  7）递归结果记忆存储：计算节点的最大路径长度时，会重复计算节点的深度，使用哈希表存储节点对应的深度 {节点：深度}，重复调用时可直接获取返回
2、计算最大路径长度递归函数
  1）方法功能：入参是一个节点，返回该节点为根节点的最大路径长度
  2）终止条件：节点为空返回0
  3）一个节点处理过程和返回结果：当前节点为根节点的最大路径长度 = 左节点的深度 + 右节点的深度
  4）递归调用：左右节点同样需要计算最大路径长度，因此调用同样的方法处理，获取结果
  5）递归顺序：前序遍历，当前节点的最大路径长度计算不依赖左右节点的路径长度，三者顺序可随意。可以先计算根节点的最大路径长度，然后计算左节点的最大路径长度，最后计算右节点的最大路径长度
  6）使用递归调用结果和返回结果：二叉树的直径 = max(根节点的最大路径长度, 左节点的最大路径长度, 右节点的最大路径长度)
 */
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left) + depth(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int depth = 1 + Math.max(left, right);
        map.put(root, depth);
        return depth;
    }
}