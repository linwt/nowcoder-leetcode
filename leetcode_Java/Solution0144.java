// 144. 二叉树的前序遍历


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
* 递归思路：遍历⼀遍⼆叉树，结果记录在全局变量中
* 1、定义数据结构：使用列表成员变量，存储每次递归操作存入的值
* 2、递归终止条件：节点为空时返回
* 3、单层递归逻辑：把节点的值存入列表
* 4、递归逻辑：
*    左右节点需要与根节点做同样的事，就要调同样的方法，即递归
*    确定递归顺序/遍历顺序，中左右
*    每层不需要接收使用递归方法返回值，列表成员变量存储了结果
* */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}


/*
递归思路：分解问题计算出答案。通过维护局部变量，存放子问题的结果，将子结果返回给上一层使用，层层累计处理，得到最终结果
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}


/*
 * 迭代思路：
 * 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点，指针指向下一个要处理的节点
 * 2、遍历条件、操作逻辑：
 *    如果当前节点为空，则从栈弹出节点
 *    存入当前节点值；右节点入栈，用来后面获取右节点的值；指向左节点
 * */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
            }
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            cur = cur.left;
        }
        return list;
    }
}


/*
 * 迭代思路：
 * 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点，指针指向下一个要处理的节点
 * 2、遍历条件、操作逻辑：
 *    存入当前节点值；当前节点入栈，用来后面获取右节点；指向左节点
 * */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }
}


/*
 * 迭代思路：
 * 1、定义数据结构：局部变量即可，列表存放结果数据，栈按序存放节点
 * 2、遍历条件、操作逻辑：
 *    存入当前节点值；右节点入栈；左节点入栈
 * 3、用左节点入栈弹出的方式代替了指针标记下一个要处理的节点
 * */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
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
 *   4）前序遍历：
 *      先插入右节点，再插入左节点
 *      插入左右节点都是在根节点右边插入，其他结点右移一位
 *   5）最大索引的节点判断完左右节点后，移除索引列表的最大索引
 *   6）最终节点列表按序排序，遍历结点列表，将节点值存入结果列表
 * */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        nodeList.add(root);
        indexList.add(0);
        while(!indexList.isEmpty()) {
            indexList.sort((o1, o2) -> o2 - o1);
            int index = indexList.get(0);
            root = nodeList.get(index);
            if (root.left != null && root.right != null) {
                nodeList.add(index + 1, root.right);
                nodeList.add(index + 1, root.left);
                indexList.add(index + 2);
                indexList.add(index + 1);
            } else if (root.left != null) {
                nodeList.add(index + 1, root.left);
                indexList.add(index + 1);
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
 * 1、简单理解：把左子树塞到根节点和右节点中间，每个节点都要做同样的操作
 * 2、节点连接步骤：
 *    1）前序遍历是中左右，即根节点→左子树→右子树
 *    2）左子树遍历的最后一个节点是 左子树的最后一个右子节点，因此要将其连接到根节点的右节点上
 *    3）根节点的右指针要指向左节点，左指针指向空，从而形成中左右的链表
 * 2、遍历逻辑：
 *    1）根指针的移动代表着前序遍历的顺序，循环遍历条件是根指针不为空
 *    2）如果根节点的左节点不为空，则进行节点连接步骤；如果为空，则将节点值存入列表，根指针指向右节点
 * 3、“114.二叉树展开为链表”的解法
 * */
class Solution {
    public List<Integer> flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}