// 7. 重建二叉树


/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
*/


/*
递归：
1、方法功能：入参是前序和中序数组，获取前序数组首元素，构造节点，然后返回该节点
2、终止条件：两个数组为空，结束
3、递归逻辑：
  1）由于需要构造左右节点，所以要将数组拆分成左右子树的两部分数组
  2）先找到头节点在中序数组的位置，将中序数组拆分成左右两部分，根据中序数组左半部分的长度 将前序数组也拆分成左右两部分
  3）需要构造左右节点，调用同样的方法，把两个数组传进去，得到左右节点
  4）根节点连接左右节点，返回根节点
4、返回值：两个数组构造出来的头节点
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}