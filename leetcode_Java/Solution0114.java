// 二叉树展开为链表


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
* 迭代思路：
* 1、简单理解：把左子树塞到根节点和右节点中间，每个节点都要做同样的操作
* 2、简单情况分析：
*    1）根节点为空：直接返回列表
*    2）只有根节点：将根节点的值存入列表，返回列表
*    3）有根节点和左节点：将左节点移到右节点的位置，遍历右节点将值存入列表，返回列表
*    4）有根节点和右节点：不用移动，遍历右节点将值存入列表，返回列表
*    5）有根节点、左节点、右节点：将左节点移到根节点和右节点中间，遍历右节点将值存入列表，返回列表
* 3、节点连接步骤：
*    1）前序遍历是中左右，即根节点→左子树→右子树
*    2）左子树遍历的最后一个节点是 左子树的最后一个右子节点，因此要将其连接到根节点的右节点上
*    3）根节点的右指针要指向左节点，左指针指向空，从而形成中左右的链表
* 4、遍历逻辑：
*    1）根指针的移动代表着前序遍历的顺序，循环遍历条件是根指针不为空
*    2）如果根节点的左节点不为空，则进行节点连接步骤；如果为空，则将节点值存入列表
*    3）根节点处理完后看，根指针指向右节点，准备下一轮判断
* 5、“144.二叉树的前序遍历”展开为链表的解法
* */
class Solution {
    public List<Integer> flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            } else {
                list.add(root.val);
            }
            root = root.right;
        }
        return list;
    }
}


/*
* 迭代思路：与上个解法相同。用队列/栈存储下一个要遍历的节点，替代了遍历指针，缺点是使用了多余的空间
* */
class Solution {
    public List<Integer> flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            } else {
                list.add(root.val);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        return list;
    }
}