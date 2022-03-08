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


/**
 * 递归思路：
 * 1、方法功能：入参是两个数组，两个数组都为空时返回空，不为空时创建、返回根节点
 * 2、递归逻辑：
 *    1）根据前、中序数组的特点，拆分出左子树和右子树两部分数组
 *    2）左右子树的数组同样可以调用这个方法，得到左右子树的根节点
 *    3）上一层使用下一层的结果，取下一层左子树的根节点作为当前层的左子节点，取下一层右子树的根节点作为当前层的右子节点
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


/**
 * 递归思路：
 * 1、数据结构：
 *    1）使用Map存放中序数组的元素和索引，方便直接获取索引，避免了重复遍历获取
 *    2）使用指针表示数组的开始和结束位置，避免了数组的拆分和拷贝，节省额外空间。注意两个指针指向的数组范围是包括左边界，不包括右边界
 * 2、递归逻辑：
 *    1）原方法入参不够用，创建一个新的方法作为递归方法
 *    2）方法的功能：终止条件，当数组为空时，前序起始、结束指针位置相同，返回空；不为空时创建、返回根节点
 *    3）通过指针划分左右子树的数组范围，调用同个方法得到左右子树的根节点
 *    4）上一层使用下一层的结果，取下一层左子树的根节点作为当前层的左子节点，取下一层右子树的根节点作为当前层的右子节点
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int left_num = i_root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }
}