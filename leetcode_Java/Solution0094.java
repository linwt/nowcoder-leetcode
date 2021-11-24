// 二叉树的中序遍历


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
* 递归思路：
* 1、定义数据结构：使用列表成员变量，存储每次递归操作存入的值
* 2、递归终止条件：节点为空时返回
* 3、单层递归逻辑：把节点的值存入列表
* 4、递归逻辑：
*    左右节点需要与根节点做同样的事，就要调同样的方法，即递归
*    确定递归顺序/遍历顺序，左中右
*    每层不需要接收使用递归方法返回值，列表成员变量存储了结果
* */
class Solution {
    public List<Integer> list = new ArrayList<>();
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
* 递归思路：等同上个实现的逻辑
* */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点，指针指向下一个要处理的节点
* 2、遍历条件、操作逻辑：
*    当前节点不为空，节点入栈，指向左节点
*    栈不为空，弹出节点，存入节点值，指向右节点
* 3、实现了中序遍历，按序存放节点入栈，按序获取节点值
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}


/*
* 迭代思路：等同上个实现的逻辑
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}


/*
* 1、莫里斯遍历：
*    1）用递归和迭代的方式都使用了辅助的空间，而莫里斯遍历的优点是没有使用任何辅助空间。
*    2）缺点是改变了整个树的结构，强行把一棵二叉树改成一段链表结构。
* 2、思路：把根节点接到左子树的最后一个右节点上，形成链表，再遍历获取链表的值
* 3、相似题：114.二叉树展开为链表，前序遍历
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode temp = root;
                root = root.left;
                temp.left = null;
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：结果列表存放排序节点值；节点列表按序存放节点；索引列表存放未判断是否有左右子节点的节点
* 2、数据结构初始化：根节点存入节点列表；索引0存入索引列表
* 3、迭代逻辑：
*   1）索引列表不为空时，说明有节点未判断是否有左右子节点，循环遍历索引列表
*   2）索引列表降序排序，取出最大索引，对该索引的节点进行操作。先处理靠右边的节点，可以防止插入节点时影响了节点列表其他节点的位置
*   3）是否有子节点存在四种情况：有左右节点、只有右节点、只有左节点、没有左右节点。要分别处理，不同情况节点最终索引位置不同
*   4）中序遍历：
*      先插入右节点，再插入左节点
*      插入右节点是在根节点右边插入，其他结点右移一位
*      插入左节点是替代了根节点的位置，根节点和其他结点右移一位
*   5）最大索引的节点判断完左右节点后，移除索引列表的最大索引
*   6）最终节点列表按序排序，遍历结点列表，将节点值存入结果列表
* */
public class Solution0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        nodeList.add(root);
        indexList.add(0);
        while (!indexList.isEmpty()) {
            indexList.sort((o1, o2) -> o2 - o1);
            int index = indexList.get(0);
            root = nodeList.get(index);
            if (root.left != null && root.right != null) {
                nodeList.add(index + 1, root.right);
                nodeList.add(index, root.left);
                indexList.add(index + 2);
                indexList.add(index);
            } else if (root.left != null) {
                nodeList.add(index, root.left);
                indexList.add(index);
            } else if (root.right != null) {
                nodeList.add(index + 1, root.right);
                indexList.add(index + 1);
            }
            indexList.remove(0);
        }
        for (TreeNode node : nodeList) {
            resList.add(node.val);
        }
        return resList;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：列表存放节点值；栈按序存放节点；哈希表标记节点是否已处理过左右节点
* 2、数据结构初始化：根节点入栈
* 3、迭代逻辑：
*    1）栈不为空时遍历栈，弹出栈顶节点
*    2）判断当前节点是否已经处理过左右节点，处理过节点值存入列表
*    3）没有则将节点按右中左顺序入栈，弹出时才会是左中右，标记当前节点已处理
* 4、标记目的：节点已经遍历过，但又暂时不能存入列表，所以需要先按序暂存在栈中，按序弹出再存入列表
*            作用与递归相同，递归是使用栈帧保存当前变量，当下一层处理完成后，就可以回到当前栈帧的状态，处理当前的数据
* */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Map<TreeNode, Boolean> flagMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (flagMap.getOrDefault(root, false)) {
                resList.add(root.val);
            } else {
                if (root.right != null) {
                    stack.push(root.right);
                }
                stack.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                flagMap.put(root, true);
            }
        }
        return resList;
    }
}