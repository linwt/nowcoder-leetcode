package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

// 按之字形顺序打印二叉树
public class Test59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode node = new TreeNode(0);
        boolean flag = false;
        while (queue.size() != 0) {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (len > 0) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }
            if (flag) {
                Collections.reverse(list);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
