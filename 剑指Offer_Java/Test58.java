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

// 对称的二叉树
public class Test58 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSameTree(pRoot.left, pRoot.right);
    }

    boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            boolean l = isSameTree(p.left, q.right);
            boolean r = isSameTree(p.right, q.left);
            return l && r;
        }
        return false;
    }
}
