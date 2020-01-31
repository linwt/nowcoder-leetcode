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

// 二叉树的镜像
public class Test18 {
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = null;
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
