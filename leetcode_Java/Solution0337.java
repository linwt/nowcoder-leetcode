// 337. 打家劫舍 III


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
通过三个方法不断递进解决问题
解法一通过递归实现，虽然解决了问题，但是复杂度太高，结果超时
解法二通过记忆化存储，解决方法一中的重复子问题，实现了性能的提升，但还是存在重复递归调用
解法三直接省去了重复子问题，递归到底部，再自底向上返回，复杂度O(n)，性能又提升了一步
 */


/*
定义递归函数：
1、方法功能：入参是一个节点，返回在该节点时能偷窃到的最高金额
2、终止条件：节点为空时返回0
3、返回结果：节点不为空时返回节点值
4、递归逻辑：
  1）爷爷作为根节点，
     爷爷偷时，两个儿子不能偷，四个孙子能偷     ==>   最高金额 = 爷爷偷钱 + 四个孙子偷钱
     爷爷不偷时，两个儿子能偷，四个孙子不能偷   ==>   最高金额 = 两个儿子偷钱
  2）根节点偷窃最高金额 = max(爷爷偷钱 + 四个孙子偷钱, 两个儿子偷钱)
  3）由于儿子、孙子都要计算偷窃最高金额，所以调用同样的方法获取结果，再拿结果进行比较处理，最终返回根节点的最高金额
5、问题：爷爷计算时会同时计算儿子和孙子，当儿子变成爷爷后，又会再计算一遍爷爷、儿子、孙子，存在重复计算
 */
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }
}


/*
增加记忆存储，避免重复子问题的重复计算，但仍然存在重复调用获取爷爷、儿子、孙子的最高金额，存在性能损耗
 */
class Solution {
    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        int maxMoney = Math.max(money, rob(root.left) + rob(root.right));
        memo.put(root, maxMoney);
        return maxMoney;
    }
}


/*
1、换一种办法来定义此问题，每个节点可选择偷或者不偷两种状态，相连节点不能一起偷
  1）当前节点选择偷时，那么两个孩子节点就不能选择偷了
  2）当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行
2、使用一个大小为 2 的数组记录节点偷不偷时的最高金额 int[] money = new int[2];  0代表不偷，1代表偷
3、任何一个节点能偷到的最高金额的状态可以定义为
  1）当前节点选择不偷：当前节点能偷到的最高金额 = 左孩子偷或不偷的最高金额 + 右孩子偷或不偷的最高金额
  2）当前节点选择偷：当前节点能偷到的最高金额 = 左孩子不偷的最高金额 + 右孩子不偷的最高金额 + 当前节点的金额
4、定义递归函数：
  1）方法功能：入参是一个节点，返回该节点偷不偷时的最高金额数组
  2）终止条件：节点为空时，返回空数组
  3）返回结果：节点不为空时，将偷和不偷的金额存入数组，返回该数组
  4）递归逻辑：由于左右孩子都要计算偷不偷时的最高金额数组，因此调用同样的方法获取结果后，再拿结果进行比较处理，最终返回根节点的最高金额数组
5、调用递归函数得到根节点偷不偷时的最高金额数组，再从两者取最大，然后返回结果
6、此解法自顶向下递归，然后自底向上返回结果，只进行一次，没有重复调用，性能提升
 */
class Solution {
    public int rob(TreeNode root) {
        int[] money = robHelper(root);
        return Math.max(money[0], money[1]);
    }

    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] money = new int[2];
        int[] leftMoney = robHelper(root.left);
        int[] rightMoney = robHelper(root.right);
        money[0] = Math.max(leftMoney[0], leftMoney[1]) + Math.max(rightMoney[0], rightMoney[1]);
        money[1] = root.val + leftMoney[0] + rightMoney[0];
        return money;
    }
}