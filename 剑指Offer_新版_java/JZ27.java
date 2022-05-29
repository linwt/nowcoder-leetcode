// 27. 二叉树的镜像


public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}


public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot != null) {
            TreeNode temp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = temp;
            Mirror(pRoot.left);
            Mirror(pRoot.right);
        }
        return pRoot;
    }
}
