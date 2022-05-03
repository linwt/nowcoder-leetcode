// 101. 对称二叉树


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
1、方法定义：
   1）由于要判断两个节点对应的左右子节点值是否相同，原方法入参只有一个节点不够用，需要再定义一个有两个节点作为入参的方法
   2）不管是原方法还是新方法，其返回类型和返回结果都跟题目要求的返回类型和返回结果一致
2、方法功能：
   1）入参是两个节点，判断两个节点是否相同
   2）节点都为空、节点都不为空且值相等则返回true；节点只有一个不为空、节点都不为空但值不相等则返回false
3、递归逻辑：
   1）两个节点的左右子节点同样可以调用这个方法，判断节点是否相同，得到true或false的结果
   2）当前层节点对称，才会继续递归下一层
   3）每一层，每两个节点作为入参，调用方法，都得到了true或false的结果
   4）上一层使用下一层的结果，将下一层多个结果进行与运算，得到下一层的节点是否对称
=======================================================================================================
新注释模板，递归
1、方法功能：判断对称需要两个节点参与，入参是两个节点，判断两个节点值是否相同，相同返回true，不同返回false
2、终止条件：两个节点都为空时，返回true
3、两个节点处理过程和返回结果：判断两个节点值是否相同，相同返回true，不同返回false
4、递归调用：两个节点对应的两对左右节点值同样需要判断是否相同，因此调用同样的方法处理，获取结果
5、递归顺序：前序遍历，先判断当前两个节点值是否相同，不同则结束返回false，相同则继续判断两对左右节点值是否相同
6、使用递归调用结果和返回结果：两对左右节点值都相同则返回true，否则返回false
            1
          /   \
         2     2
       /   \ /   \
      3    4 4    3
* */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            boolean l = isSameTree(p.left, q.right);
            boolean r = isSameTree(p.right, q.left);
            return l && r;
        }
        return false;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：队列按序存放节点
* 2、队列初始化：将根节点的左右节点存入队列
* 3、迭代逻辑：
*    1）遍历队列，弹出两个节点，比较是否相同
*    2）不相同则返回false。都为空、都不为空且值相等，则存入两个节点对应的下一层的四个左右子节点节点
*    3）最终节点都存入了队列，且弹出判断都两两相同，则返回true
* */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p != null && q != null && p.val == q.val) {
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
                continue;
            }
            return false;
        }
        return true;
    }
}