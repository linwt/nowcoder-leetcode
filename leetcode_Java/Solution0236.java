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
====================================================================================================
新模板注释，递归
1、方法功能：入参是一个根节点、两个目标节点，寻找与目标节点相同的节点，存在则返回该节点，不存在则返回空
2、终止条件：节点为空时，返回空
3、一个节点处理过程和返回结果：节点等于其中一个目标节点时，返回该节点，否则返回空
4、递归调用：左右节点同样需要寻找目标节点，因此调用同样的方法处理，获取结果
5、递归顺序：前序遍历，当前节点处理后能找到则返回，找不到再继续从左右节点找
6、使用递归调用结果和返回结果：
  1）左节点找到 且 右节点找到，那么最近公共祖先是根节点
  2）左节点 或 右节点 只有一个找到，那么最近公共祖先是 左节点 或 右节点
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

/*
上面解法的单节点处理逻辑
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        return null;
    }
}