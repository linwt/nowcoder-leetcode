# 中序遍历获取结点值数组，依次连接结点为右孩子
class Solution(object):
    def increasingBST(self, root):
        if not root:
            return []

        def inorder(root):
            if root:
                inorder(root.left)
                res.append(root.val)
                inorder(root.right)

        res = []
        inorder(root)
        head1 = TreeNode(res[0])
        head2 = head1
        for v in res[1:]:
            head2.right = TreeNode(v)
            head2 = head2.right
        return head1