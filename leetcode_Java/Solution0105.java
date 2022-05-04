// 105. 从前序与中序遍历序列构造二叉树


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
递归思路：
1、方法功能：入参是两个数组，两个数组都为空时返回空，不为空时创建、返回根节点
2、递归逻辑：
   1）根据前、中序数组的特点，拆分出左子树和右子树两部分数组
   2）左右子树的数组同样可以调用这个方法，得到左右子树的根节点
   3）上一层使用下一层的结果，取下一层左子树的根节点作为当前层的左子节点，取下一层右子树的根节点作为当前层的右子节点
===============================================================================================
构造节点递归函数
1、方法功能：入参是前序、中序数组，构造根节点，并返回根节点
2、终止条件：两个数组都为空时，返回空
3、一个节点处理过程和返回结果：获取前序数组首元素，构造根节点，返回根节点
4、递归调用：左右节点同样需要构造，因此调用同样的方法递归处理，获取结果
5、递归顺序：前序遍历，要先构造根节点，再去构造左右节点
6、使用递归调用结果和返回结果：获取左右节点后，将其与根节点连接，然后返回根节点
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = Arrays.asList(Arrays.stream(inorder).boxed().toArray(Integer[]::new)).indexOf(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
}


/*
递归思路：
1、数据结构：
   1）使用Map存放中序数组的元素和索引，方便直接获取索引，避免了重复遍历获取
   2）使用指针表示数组的开始和结束位置，避免了数组的拆分和拷贝，节省额外空间。注意两个指针指向的数组范围是包括左边界，不包括右边界
2、递归逻辑：
   1）原方法入参不够用，创建一个新的方法作为递归方法
   2）方法的功能：终止条件，当数组为空时，前序起始、结束指针位置相同，返回空；不为空时创建、返回根节点
   3）通过指针划分左右子树的数组范围，调用同个方法得到左右子树的根节点
   4）上一层使用下一层的结果，取下一层左子树的根节点作为当前层的左子节点，取下一层右子树的根节点作为当前层的右子节点
============================================================================================================
新注释模板，递归
构造节点递归函数
1、方法功能：入参是两个数组、对应的开始和结束边界
2、终止条件：开始边界等于结束边界，说明数组为空，返回空
3、一个节点处理过程和返回结果：获取前序数组首元素，构造根节点，返回根节点
4、递归调用：左右节点同样需要构造，因此调用同样的方法递归处理，获取结果
5、递归顺序：前序遍历，要先构造根节点，再去构造左右节点
6、使用递归调用结果和返回结果：获取左右节点后，将其与根节点连接，然后返回根节点
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int iRootIndex = map.get(rootVal);
        int leftNum = iRootIndex - iStart;
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex);
        root.right = buildTreeHelper(preorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd);
        return root;
    }
}


/*
迭代：
1、用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（前序遍历的第一个节点），指针指向中序遍历的第一个节点
2、依次枚举前序遍历中除了第一个节点以外的每个节点
  1）如果 index 恰好指向栈顶节点，那么不断地弹出栈顶节点并向右移动 index，并将当前节点作为最后一个弹出的节点的右儿子
  2）如果 index 和栈顶节点不同，将当前节点作为栈顶节点的左儿子
  3）无论是哪一种情况，最后都将当前的节点入栈

preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
        3
       / \
      9  20
     /  /  \
    8  15   7
   / \
  5  10
 /
4
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}