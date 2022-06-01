// 77. 按之字形顺序打印二叉树


public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = false;
        while (queue.size() != 0) {
            int len = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.poll();
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
