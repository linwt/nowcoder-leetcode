package offer;

import java.util.ArrayList;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/

// 二叉树中和为某一值的路径
public class Test24 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<Integer>(list));
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
        list.remove(list.size() - 1);
        return res;
    }
}
