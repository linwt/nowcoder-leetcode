// 662. 二叉树最大宽度


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
位置角度：起始位置为1，某个节点在数组中的位置为i，则其
1)父节点位置：i/2
2)左子节点位置：2i
3)右子节点位置：2i+1

递归：
1、成员变量最大宽度maxWidth，哈希表map保存每层第一个节点的位置值 {层数:首节点位置}
2、定义递归函数：
  1）方法功能：入参是节点、深度、位置，从map中获取同深度即同层的第一个节点位置，更新计算最大宽度
  2）终止条件：节点为空时，结束
  3）递归逻辑：左右节点同样需要计算其所在层的宽度，因此调用同样的方法递归处理
===============================================================================
新模板注释，递归
1、方法功能：入参是节点、层数、节点位置，计算当前层 当前节点与首节点的宽度，更新最大宽度
2、终止条件：节点为空时，结束
3、一个节点处理过程和返回结果：map没有当前层首节点位置，则将当前节点位置存入。计算当前层 当前节点与首节点的距离，更新最大宽度
4、递归调用：左右节点同样需要计算宽度，因此调用同样的方法递归处理
5、递归顺序：前序遍历，左右节点的
6、使用递归调用结果和返回结果
 */
class Solution {
    private int maxWidth = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return maxWidth;
    }

    private void dfs(TreeNode root, int layer, int pos) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(layer, key -> pos);
        maxWidth = Math.max(maxWidth, pos - map.get(layer) + 1);
        dfs(root.left, layer + 1, 2 * pos);
        dfs(root.right, layer + 1, 2 * pos + 1);
    }
}


/*
迭代：
1、节点为空时返回0
2、使用两个队列，节点队列nodeQueue存放节点，位置队列posQueue存放节点的位置值，初始化时加入根节点和位置值到队列中
3、位置关系：根节点位置为 i，则左节点位置为 2i，有节点位置为 2i+1
4、层序遍历，记录当前层最左边的位置，遍历更新右边的位置，计算更新当前层宽度，并把下一层的节点和位置值存入队列
5、每层遍历完后都更新最大宽度，最终得到二叉树的最大宽度

    1
  /   \
 2     3
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        nodeQueue.add(root);
        posQueue.add(1);
        int maxWidth = 0;
        while (!nodeQueue.isEmpty()) {
            boolean firstFlag = true;
            int left = -1, right = -1, tempWidth = 0;
            int size = nodeQueue.size();
            while(size > 0) {
                TreeNode node = nodeQueue.poll();
                int pos = posQueue.poll();
                if (firstFlag) {
                    left = pos;
                    firstFlag = false;
                }
                right = pos;
                tempWidth = Math.max(tempWidth, right - left + 1);
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    posQueue.add(2 * pos);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    posQueue.add(2 * pos + 1);
                }
                size--;
            }
            maxWidth = Math.max(maxWidth, tempWidth);
        }
        return maxWidth;
    }
}


/*
迭代优化：位置队列posQueue存放的是一层节点的所有位置，直接取最左边和最右边的位置就可以计算当前层的宽度，再更新最大宽度
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> posQueue = new LinkedList<>();
        nodeQueue.add(root);
        posQueue.add(1);
        int maxWidth = 0;
        while (!nodeQueue.isEmpty()) {
            maxWidth = Math.max(maxWidth, posQueue.peekLast() - posQueue.peekFirst() + 1);
            int size = nodeQueue.size();
            while(size > 0) {
                TreeNode node = nodeQueue.poll();
                int pos = posQueue.poll();
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    posQueue.add(2 * pos);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    posQueue.add(2 * pos + 1);
                }
                size--;
            }
        }
        return maxWidth;
    }
}