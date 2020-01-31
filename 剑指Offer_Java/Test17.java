package offer;

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

// 树的子结构
public class Test17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return IsSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean IsSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return IsSubtree(root1.left, root2.left) && IsSubtree(root1.right, root2.right);
    }
}
