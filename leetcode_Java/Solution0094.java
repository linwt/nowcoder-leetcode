// 二叉树的中序遍历


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
*    确定递归顺序/遍历顺序，左中右
*    每层不需要接收使用递归方法返回值，列表成员变量存储了结果
* */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}


/*
* 递归思路：等同上个实现的逻辑
* */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点，指针指向下一个要处理的节点
* 2、遍历条件、操作逻辑：
*    当前节点不为空，节点入栈，指向左节点
*    栈不为空，弹出节点，存入节点值，指向右节点
* 3、实现了中序遍历，按序存放节点入栈，按序获取节点值
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}


/*
* 迭代思路：等同上个实现的逻辑
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}


/*
* 莫里斯遍历：用递归和迭代的方式都使用了辅助的空间，而莫里斯遍历的优点是没有使用任何辅助空间。
* 缺点是改变了整个树的结构，强行把一棵二叉树改成一段链表结构。
* 思路：把根节点接到左子树的最后一个右节点上，形成链表，再遍历获取链表的值
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}