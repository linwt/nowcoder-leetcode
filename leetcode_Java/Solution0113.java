// 113. 路径总和 II


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
递归，回溯：
1、成员变量 res 存放结果路径，path 存放搜索过程路径
2、定义递归函数
  1）方法功能：入参是节点、目标和，将节点值加入path路径列表，当节点为叶子结点 且 节点值等于目标和，则将路径加入res结果列表。处理结果加入列表即可，不需要返回
  2）终止条件：节点为空时，结束
  3）递归逻辑：左右节点同样需要加入路径、判断目标和，因此调用同样的方法实现递归处理。当前节点递归处理完成后需要从路径中移除节点值，即回溯，不影响其他路径的递归处理
=======================================================================================================================================
新注释模板，递归
1、方法功能：入参是节点、目标和，将节点值加入path路径列表，当节点为叶子结点 且 节点值等于目标和，则将路径加入res结果列表
2、终止条件：节点为空时，结束
3、一个节点处理过程和返回结果：将节点值加入path路径列表，当节点为叶子结点 且 节点值等于目标和，则将路径加入res结果列表
4、递归调用：左右节点同样需要加入路径、判断目标和，因此调用同样的方法递归处理。递归参数目标和累减，减去当前节点值。
5、递归顺序：前序遍历，路径顺序从根节点到叶结点，所以要先处理根节点，再处理左右节点
          当前节点递归处理完成后需要从路径中移除节点值，即回溯，不影响其他路径的递归处理
6、使用递归调用结果和返回结果：没有返回值需要接收，最后返回res结果列表即可
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new ArrayList<>(path));
        }
        targetSum -= root.val;
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}


/*
广度优先搜索：
1、成员变量 res 存放结果路径；map存放 {节点:父节点} 关系，用于根据叶子结点找出整条路径
2、层序遍历节点，利用两个队列分别保存 节点 和 到达节点时的路径和
3、当节点是叶子节点时，判断路径和等于目标和则获取路径加入res结果列表中。
   否则将左右节点与其对应的路径和加入队列中，并且保存左右节点与父节点的关系到map中，然后继续循环处理
4、最后返回res结果列表
 */
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer sum = sumQueue.poll();
            if (node.left == null && node.right == null && sum == targetSum) {
                getPath(node);
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(sum + node.left.val);
                map.put(node.left, node);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(sum + node.right.val);
                map.put(node.right, node);
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        List<Integer> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node.val);
            node = map.get(node);
        }
        res.add(new ArrayList<>(path));
    }
}