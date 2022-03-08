// 589. N叉树的前序遍历


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


/*
 * 递归思路：
 * 1、定义数据结构：使用列表成员变量，存储每次递归操作存入的值
 * 2、递归终止条件：节点为空时返回
 * 3、单层递归逻辑：把节点的值存入列表
 * 4、递归逻辑：
 *    子节点需要与根节点做同样的事，就要调同样的方法，即递归
 *    确定递归顺序/遍历顺序，中左右，子节点从左到右
 *    每层不需要接收使用递归方法返回值，列表成员变量存储了结果
 * */
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }
}


/*
* 迭代思路：
* 1、定义数据结构：列表存放节点值，栈按序存放节点
* 2、遍历条件、操作逻辑：
*    1）节点入栈顺序决定了节点的遍历顺序，栈的后进先出特点，想实现前序遍历，子节点要从右到左入栈，出栈从左到右操作节点，先存储后操作
*    2）根节点入栈初始化，轮询栈，弹出节点，节点值存入列表，子节点从右到左入栈
* */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            List<Node> children = root.children;
            Collections.reverse(children);
            for (Node node : children) {
                stack.push(node);
            }
        }
        return list;
    }
}