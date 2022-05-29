// 54. 二叉搜索树的第k个结点


/*
中序遍历保存到数组，取第k个元素
 */
public class Solution {
    private ArrayList<Integer> list = new ArrayList<>();

    public int KthNode (TreeNode proot, int k) {
        if (proot == null || k == 0) {
            return -1;
        }
        inOrder(proot);
        if (k > list.size()) {
            return -1;
        }
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}


public class Solution {
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            count++;
            if (count == k) {
                return pRoot;
            }
            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }
}
