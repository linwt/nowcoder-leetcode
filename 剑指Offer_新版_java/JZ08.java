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


/*
迭代：
1、中序遍历：左中右。根据这个顺序寻找下一个节点
2、如果二叉树为空，则返回空
3、如果节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
4、如果节点右孩子不存在，则当节点不是根节点时，如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
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
