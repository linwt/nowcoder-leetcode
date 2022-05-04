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
“102.二叉树的层序遍历”，奇数层正序插入节点值，偶数层逆序插入节点值
 */
class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 1);
        return list;
    }

    public void dfs(TreeNode root, int layer) {
        if (root == null) {
            return;
        }
        if (list.size() < layer) {
            list.add(new ArrayList<>());
        }
        if (layer % 2 == 1) {
            list.get(layer - 1).add(root.val);
        } else {
            list.get(layer - 1).add(0, root.val);
        }
        dfs(root.left, layer + 1);
        dfs(root.right, layer + 1);
    }
}


/*
“102.二叉树的层序遍历”，加上是否反转标记，奇数层不变，偶数层反转子数组
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