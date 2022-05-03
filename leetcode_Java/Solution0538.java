// 538. 把二叉搜索树转换为累加树


/**
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
递归：
1、方法功能：入参是一个节点，将该节点值 加上 比它大的节点值之和，返回该节点
2、终止条件：节点为空时返回空
3、一个节点处理过程和返回结果：将该节点值 加上 比它大的节点值之和，返回该节点
4、递归调用：左右节点同样需要累加，因此调用同样的方法递归处理
5、递归顺序：反中序遍历，右根左，节点值从大到小遍历，并累加记录到成员变量num。因此要先处理右节点，再处理根节点，最后处理左节点
6、使用递归调用结果和返回结果：不用接收返回结果，累加处理即可，最后返回根节点
 */
class Solution {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += num;
        num = root.val;
        convertBST(root.left);
        return root;
    }
}


/*
同上
 */
public class Solution {
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