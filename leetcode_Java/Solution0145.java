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
 * 3、主要数据操作：把节点的值存入列表
 * 4、递归逻辑：
 *    左右节点需要与根节点做同样的事，就要用递归
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