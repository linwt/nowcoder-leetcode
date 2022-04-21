// 86. 在二叉树中找到两个节点的最近公共祖先


/*
思路同“236. 二叉树的最近公共祖先”
1、不利用二叉搜索树性质，直接当成普通二叉树进行节点遍历
2、函数功能：在节点中找p、q，找不到返回-1，找到了返回该节点值 不继续往下找了
3、递归逻辑：
  1）根节点找不到时，要再判断左右节点能否找到，因此调用递归函数得到左右节点寻找结果
  2）拿结果做判断，如果左右都能找到，说明p、q在左右两边，当前根节点是最近公共祖先，返回根节点值
  3）如果左边找到了，右边没找到，说明p、q都在左边，左边的节点值是最近公共祖先
    如果右边找到了，左边没找到，说明p、q都在右边，右边的节点值是最近公共祖先
 */
public class Solution {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root == null) {
            return -1;
        }
        if (root.val == p || root.val == q) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, p, q);
        int right = lowestCommonAncestor(root.right, p, q);
        if (left != -1 && right != -1) {
            return root.val;
        }
        return left != -1 ? left : right;
    }
}