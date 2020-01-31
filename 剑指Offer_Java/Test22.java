package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/

public class Test22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            list.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return list;
    }
}
