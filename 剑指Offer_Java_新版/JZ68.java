// 68. 二叉搜索树的最近公共祖先


/*
递归：
1、随便给2个数，利用二叉搜索树的性质：
  1）如果两个值都小于根节点，说明公共祖先在左子树一侧
  2）如果两个值都大于根节点，说明公共祖先在右子树一侧
  3）如果根节点的值恰好在两个给定值之间，或者根节点的值等于其中一个给定值，这个根节点就是最近的公共祖先
2、函数功能：在节点中找p、q。有两种情况才会返回
  1）直接找到了p或q，返回该节点值
  2）p和q分别在左右子树，返回根节点值
3、return root.val; 省略了if条件，即 p <= root <= q 或 q <= root <= p，

   root       p         q
   /  \      /  \      /  \
  p    q    x    q    x    p
              p         q
             /  \      /  \
            q    x    p    x
 */
public class Solution {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root.val;
        }
    }
}


/*
迭代
 */
public class Solution {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        while (true) {
            if (root.val < p && root.val < q) {
                root = root.right;
            } else if (root.val > p && root.val > q) {
                root = root.left;
            } else {
                return root.val;
            }
        }
    }
}


/*
思路同剑指“86. 在二叉树中找到两个节点的最近公共祖先”、力扣“236. 二叉树的最近公共祖先”
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