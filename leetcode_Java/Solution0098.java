// 98. 验证二叉搜索树


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/*
有效二叉搜索树定义如下：
1、节点的左子树只包含 小于 当前节点的数。
2、节点的右子树只包含 大于 当前节点的数。
3、所有左子树和右子树自身必须也是二叉搜索树。
 */


/*
中序遍历：
1、方法功能：入参是一个节点，判断当前节点是否比前一节点大，不是则返回false，是则返回true
2、终止条件：节点为空时返回true，才能继续遍历不为空的节点
3、单节点处理过程和返回结果：判断当前节点是否比前一节点大，不是则返回false，是则保存当前节点值，并返回true
4、递归调用：左右节点需要同样的操作，因此调用同样的方法处理，获取结果
5、递归顺序：中序遍历，根节点的处理依赖左节点的值，右节点的处理依赖根节点的值。需要中序遍历有序地保存前一节点值，给下一节点判断
6、使用递归调用结果和返回结果：
  1）左节点不满足则返回false，满足则继续判断根节点；
  2）根节点不满足则返回false，满足则继续判断右节点；
  3）右节点不满足则返回false，满足则返回true，即直接返回右节点处理结果即可
 */
class Solution {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}


/*
递归：
1、方法功能：入参是节点、最小值、最大值，判断节点值是否有效，即是否满足 min < val < max，有效返回true，无效返回false
2、终止条件：节点为空返回true
3、单节点处理过程和返回结果：判断节点值是否有效，即是否满足 min < val < max，有效效返回true，无效返回false
4、递归调用：左右节点需要同样的操作，因此调用同样的方法处理，获取结果
5、递归顺序：前序遍历，左右节点的处理依赖根节点的值，所以要先处理根节点，再处理左右节点
6、使用递归调用结果和返回结果：左右节点同时有效则返回true，否则返回false
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}


/*
“94. 二叉树的中序遍历”，中序遍历存入列表，再遍历判断是否升序
 */
class Solution {
    public List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}


/*
迭代：“94. 二叉树的中序遍历”，中序遍历过程更新保存前一节点值，当前节点值小于等于前一节点值，则无效，否则有效
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.val <= pre) {
                    return false;
                }
                pre = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}