// 34. 二叉树中和为某一值的路径(二)


/*
回溯：
1、变量作用：
  1）成员变量 list 保存回溯过程产生的子结果
  2）局部变量 pathList 保存递归到当前节点时路径上的节点值
  3）局部变量 target 表示到达当前节点后剩余目标值，当剩余0时表示凑到了期望值
2、递归：
  1）函数作用：累减剩余目标值，将当前节点值加入路径列表，判断剩余目标值是否为0 且 是否为叶结点，若是则将路径列表加入全局列表
  2）终止条件：节点为空时终止
  3）递归：左右子节点需要同样的操作，调用同样的方法实现
  4）回溯：返回到上一层前需要将当前层加入的节点值移除，不影响其他路径递归
 */
public class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int expectNumber) {
        ArrayList<Integer> pathList = new ArrayList<>();
        backtrack(root, expectNumber, pathList);
        return list;
    }

    private void backtrack(TreeNode root, int target, ArrayList<Integer> pathList) {
        if (root == null) {
            return;
        }
        target -= root.val;
        pathList.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(pathList));
        }
        backtrack(root.left, target, pathList);
        backtrack(root.right, target, pathList);
        pathList.remove(pathList.size() - 1);
    }
}