// 36. 二叉搜索树与双向链表


public class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        midOrder(pRootOfTree);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode pre = list.get(i);
            TreeNode after = list.get(i + 1);
            pre.right = after;
            after.left = pre;
        }
        return list.get(0);
    }

    public void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            list.add(root);
            midOrder(root.right);
        }
    }
}
