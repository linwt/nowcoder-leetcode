// 8. 二叉树的下一个结点


/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/


public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode node = new TreeLinkNode(0);
        if (pNode.right != null) {
            node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (pNode.next != null) {
            node = pNode.next;
            if (node.left == pNode) {
                return node;
            }
            pNode = node;
        }
        return null;
    }
}
