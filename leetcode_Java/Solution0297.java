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
深度优先搜索：
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
        Deque<String> queue = new LinkedList<>(Arrays.asList(splits));
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
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
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
        Deque<TreeNode> queue = new LinkedList<>();
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