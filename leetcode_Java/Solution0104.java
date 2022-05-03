// 104. 二叉树的最大深度


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
递归思路：
1、方法功能：入参是一个节点，节点为空返回0，节点不为空返回1
2、递归逻辑：
   1）左右节点同样可以调用这个方法，得到0或1的结果
   2）每一层，每个节点，调用方法，都得到了0或1的结果
   3）上一层使用下一层的结果，取下一层左右节点结果的最大值，累加到当前层，从而得到二叉树的最大深度
==================================================================================
计算深度递归函数
1、方法功能：入参是一个节点，返回节点的深度
2、终止条件：节点为空时返回0
3、一个节点处理过程和返回结果：节点不为空时返回1
4、递归调用：左右节点同样需要计算深度，因此调用同样的方法处理，获取结果
5、递归顺序：后序遍历，当前节点的深度计算依赖左右节点的深度
6、使用递归调用结果和返回结果：当前节点的深度 = 1 + max(左节点深度, 右节点深度)
* */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }
}


/*
* 迭代思路：
* 1、定义数据结构：队列存放每一层的节点
* 2、定义局部变量：deep记录深度；count记录每层节点个数，以便标记队列节点每层结束位置
* 2、实现逻辑：层序遍历，遍历当前层节点时，把下一层节点存入队列，每一层遍历结束后，深度加1，最终得到最大深度
* */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 0;
        int count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count > 0) {
                root = queue.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
                count--;
            }
            deep++;
        }
        return deep;
    }
}