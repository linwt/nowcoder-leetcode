// 103. 二叉树的锯齿形层序遍历


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
102.二叉树的层序遍历，加上是否反转标记，奇数层不变，偶数层反转子数组
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> sonList = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.remove();
                sonList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            if (flag) {
                Collections.reverse(sonList);
            }
            list.add(sonList);
            flag = !flag;
        }
        return list;
    }
}