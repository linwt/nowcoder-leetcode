// 236. 二叉树的最近公共祖先


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
1、若root是p,q的最近公共祖先，那么有三种情况，即 p <= root <= q 或 q <= root <= p
  1）p、q分别在root的左右子树上
  2）p=root，且q在root的左或右子树上
  3）q=root，且p在root的左或右子树上
2、函数功能：在节点中找p、q，找不到返回null，找到了返回该节点 不继续往下找了。即第一个if语句就代表函数最基本的功能。
3、递归逻辑：
  1）根节点找不到时，要再判断左右节点能否找到，因此调用递归函数得到左右节点寻找结果
  2）拿结果做判断，如果左右都能找到，说明p、q在左右两边，当前根节点是最近公共祖先，返回根节点
  3）如果左边找到了，右边没找到，说明p、q都在左边，左边的节点是最近公共祖先
    如果右边找到了，左边没找到，说明p、q都在右边，右边的节点是最近公共祖先

   root       p         q
   /  \      /  \      /  \
  p    q    x    q    x    p
              p         q
             /  \      /  \
            q    x    p    x
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}