// 二叉树的后序遍历


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
 * 递归思路：
 * 1、定义数据结构：使用列表成员变量，存储每次递归操作存入的值
 * 2、递归终止条件：节点为空时返回
 * 3、单层递归逻辑：把节点的值存入列表
 * 4、递归逻辑：
 *    左右节点需要与根节点做同样的事，就要调同样的方法，即递归
 *    确定递归顺序/遍历顺序，左右中
 *    每层不需要接收使用递归方法返回值，列表成员变量存储了结果
 * */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}


/*
 * 迭代思路：
 * 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点
 * 2、遍历条件、操作逻辑：
 *    如果当前节点为空，则从栈弹出节点
 *    存入节点值，预存右节点入栈，指向左节点
 * */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.right == null || cur.right == pre) {
                list.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }
}


/*
* 迭代思路：144题，前序遍历的迭代思路，结果数组反转
* */


/*
 * 迭代思路：
 * 1、定义数据结构：结果列表存放排序节点值；节点列表按序存放节点；索引列表存放未判断是否有左右子节点的节点
 * 2、数据结构初始化：根节点存入节点列表；索引0存入索引列表
 * 3、迭代逻辑：
 *   1）索引列表不为空时，说明有节点未判断是否有左右子节点，循环遍历索引列表
 *   2）索引列表降序排序，取出最大索引，对该索引的节点进行操作。先处理靠右边的节点，可以防止插入节点时影响了节点列表其他节点的位置
 *   3）是否有子节点存在四种情况：有左右节点、只有右节点、只有左节点、没有左右节点。要分别处理，不同情况节点最终索引位置不同
 *   4）后序遍历：
 *      先插入右节点，再插入左节点
 *      插入左右节点都是替代了根节点的位置，其他结点右移一位
 *   5）最大索引的节点判断完左右节点后，移除索引列表的最大索引
 *   6）最终节点列表按序排序，遍历结点列表，将节点值存入结果列表
 * */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        nodeList.add(root);
        indexList.add(0);
        while(!indexList.isEmpty()) {
            indexList.sort((o1, o2) -> o2 - o1);
            int index = indexList.get(0);
            root = nodeList.get(index);
            if (root.left != null && root.right != null) {
                nodeList.add(index, root.right);
                nodeList.add(index, root.left);
                indexList.add(index + 1);
                indexList.add(index);
            } else if (root.left != null) {
                nodeList.add(index, root.left);
                indexList.add(index);
            } else if (root.right != null) {
                nodeList.add(index, root.right);
                indexList.add(index);
            }
            indexList.remove(0);
        }
        for (TreeNode node : nodeList) {
            resList.add(node.val);
        }
        return resList;
    }
}