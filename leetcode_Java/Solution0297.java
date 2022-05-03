// 297. 二叉树的序列化与反序列化


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


/*
递归：
1、序列化：
  1）方法功能：入参是一个节点，返回节点的序列化结果
  2）终止条件：节点为空时，返回 "X,"
  3）一个节点处理过程和返回结果：节点不为空，返回 "节点值,"
  4）递归调用：左右节点同样需要序列化，因此调用同样的方法递归处理，获取结果
  5）递归顺序：后序遍历，要构造“根左右”的序列化结果，需要先处理左右节点，再处理根节点
  6）使用递归调用结果和返回结果：获取左右节点的序列化结果，构造返回 "根节点值,左节点值,右节点值,"
2、反序列化：序列化字符串先根据逗号分隔数组，再解析成队列
  1）方法功能：入参是一个队列，弹出队头字符串，解析成数字后，构造根节点，返回该节点
  2）终止条件：字符串为"X"，返回空
  3）一个节点处理过程和返回结果：队头字符串，解析成数字后，构造根节点，返回该节点
  4）递归调用：左右节点同样需要构造，因此调用同样的方法递归处理，获取结果
  5）递归顺序：前序遍历，要先构造根节点，再构造左右节点
  6）使用递归调用结果和返回结果：获取左右节点后，将其与根节点连接，返回根节点
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        return root.val + "," + leftSerialize + rightSerialize;
    }

    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(splits));
        return build(queue);
    }

    private TreeNode build(Deque<String> queue) {
        String s = queue.poll();
        if (s.equals("X")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = build(queue);
        node.right = build(queue);
        return node;
    }
}


/*
广度优先搜索：
1、序列化：层序遍历，用队列存放节点，遍历当前层的同时添加下一层节点，每层节点从左到右转化成字符串，空节点为 "X,"，非空节点为 "节点值,"
2、反序列化：
  1）序列化字符串先根据逗号分隔数组，获取数组首元素构造根节点，将根节点加入队列。
  2）从队列弹出节点后，再从序列化数组获取该节点的左右节点字符串，构造左右节点，并将左右节点加入队列。循环读取队列，直到全部构造完成
  3）返回根节点
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        StringBuilder sb = new StringBuilder();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("X,");
                }
                size--;
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("X,")) {
            return null;
        }
        String[] splits = data.split(",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"X".equals(splits[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(splits[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (!"X".equals(splits[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(splits[i]));
                node.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}