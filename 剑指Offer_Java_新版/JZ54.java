// 54. 二叉搜索树的第k个结点


/*
中序遍历保存到数组，取第k个元素
 */
public class Solution {
    private ArrayList<Integer> list = new ArrayList<>();

    public int KthNode (TreeNode proot, int k) {
        if (proot == null || k == 0) {
            return -1;
        }
        inOrder(proot);
        if (k > list.size()) {
            return -1;
        }
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}


/*
1、方法功能：入参是 一个节点 和 目标节点位号，遍历找出并返回目标节点，没有则返回空
2、终止条件：节点为空时，返回空
3、一个节点处理过程和返回结果：累加位号，如果等于目标节点位号则返回该节点，否则返回空
4、递归调用：左右节点同样需要寻找判断是否目标节点，因此调用同样的方法
5、递归顺序：中序遍历，可以从小到大遍历节点
6、使用递归调用结果和返回结果：
  1）左节点递归结果不为空时，说明找到了目标节点，返回该结果，否则继续判断根节点
  2）累加位号，如果等于目标节点位号则返回该节点，否则继续判断右节点
  3）右节点递归结果不为空时，说明找到了目标节点，返回该结果。否则说明没有目标位号的节点，返回空
 */
public class Solution {
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) {
            return node;
        }
        count++;
        if (count == k) {
            return pRoot;
        }
        node = KthNode(pRoot.right, k);
        if (node != null) {
            return node;
        }
        return null;
    }
}
