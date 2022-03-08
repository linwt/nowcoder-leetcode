// 102. 二叉树的层序遍历


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
* 迭代思路：
* 1、定义数据结构：二维列表存放结果；队列按序存放每层节点；临时子列表存放每层节点值
* 2、辅助标记：整型变量标记每层在队列的节点个数，以便维护二维列表
* 3、实现逻辑：遍历当层节点，节点值存入子列表，下一层节点从左到右按序存入队列，循环遍历队列节点
* 4、队列：先进先出，尾部存入，头部移除
* */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> sonList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count;
        while (!queue.isEmpty()) {
            count = queue.size();
            while (count > 0) {
                root = queue.remove();
                sonList.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
                count--;
            }
            list.add(sonList);
            sonList = new ArrayList<>();
        }
        return list;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：二维列表存放结果；队列按序存放每层节点；临时子列表存放每层节点值
* 2、辅助标记：在队列中，每一层的尾部添加哨兵，标记该层的结束位置
* 2、实现逻辑：
*    1）先将根节点和哨兵加入队列，初始化第一层
*    2）通过对象类型区分节点与哨兵。
*      如果是节点，则将节点值存入子列表，将左右节点存入队列。
*      如果是哨兵，表示当前层结束，将子列表存入结果列表。如果队列还有元素即还有下一层，则创建新的子列表存放下一层节点值，在队列尾部添加哨兵，标记下一层的结束位置
* */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> sonList = new ArrayList();
        Queue<Object> queue = new LinkedList<>();
        queue.add(root);
        queue.add(0);
        while (!queue.isEmpty()) {
            Object obj = queue.remove();
            if (obj instanceof TreeNode) {
                TreeNode node = (TreeNode) obj;
                sonList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                list.add(sonList);
                if (!queue.isEmpty()) {
                    sonList = new ArrayList();
                    queue.add(0);
                }
            }
        }
        return list;
    }
}


/*
* 递归思路：
* 1、定义数据结构：成员变量：列表存放递归结果
*               局部变量：子列表存放每层节点值
* 2、辅助标记：整型变量标记 层的深度 对应 子列表的索引
* 3、递归逻辑：
*    1）前序遍历，深度优先搜索，每个节点都会遍历到，每层节点最终都是从左到后按序访问
*    2）记录节点所在层的深度，每到新的一层就创建一个新的子列表，层的深度对应子列表的索引，节点值层序存放
* */
class Solution {
    public List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        return dfs(root, 0);
    }

    public List<List<Integer>> dfs(TreeNode root, int deep) {
        if (root == null) {
            return list;
        }
        deep++;
        if (list.size() < deep) {
            List<Integer> sonList = new ArrayList<>();
            list.add(sonList);
        }
        list.get(deep - 1).add(root.val);
        dfs(root.left, deep);
        dfs(root.right, deep);
        return list;
    }
}