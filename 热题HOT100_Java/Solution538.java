package HOT100;


/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
*/


// 把二叉搜索树转换为累加树
public class Solution538 {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += num;
            num = root.val;
            convertBST(root.left);
        }
        return root;
    }

}
