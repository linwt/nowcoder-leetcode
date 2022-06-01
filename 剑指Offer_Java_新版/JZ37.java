// 37. 序列化二叉树


public class Solution {
    int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        String[] splits = str.split(",");
        String s = splits[index];
        TreeNode root = null;
        if (!s.equals("#")) {
            root = new TreeNode(Integer.parseInt(s));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
