// 翻转二叉树


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
* 1、方法功能：节点为空时返回空，节点不为空时把节点的左右子节点交换一下
* 2、递归逻辑：
*    1）每一层，每个节点，都需要将其左右子节点交换，就需要调用同个方法
*    2）方法功能是交换节点，不需要接收下一层的返回值给上一层使用
*    3）所有节点都交换完成后，返回根节点
* */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：栈存放要交换其左右子节点的节点
* 2、保留根节点指针：根节点指针赋值给新节点指针，使用新节点指针遍历节点，最终需要返回根节点指针
*   （实例对象存储在堆内存中，对象变量存储在栈中，对象变量就是一个引用，也表示指针，对象变量的赋值就是指针指向的改变）
* 3、栈初始化：将新节点存入栈
* 4、迭代逻辑：
*    1）弹出节点，判断节点的左右子节点是否都为空，为空则跳过
*    2）左右子节点不都为空，则进行节点交换
*    3）然后将不为空的节点存入栈中
*    4）遍历了所有节点且交换了其左右子节点，则翻转二叉树完成，返回根节点
* */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        stack.push(curNode);
        while (!stack.isEmpty()) {
            curNode = stack.pop();
            if (curNode.left == null && curNode.right == null) {
                continue;
            }
            TreeNode tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        return root;
    }
}