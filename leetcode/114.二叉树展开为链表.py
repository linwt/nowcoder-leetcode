# 方法一：前序遍历得到结点数组，令每个结点的左孩子为空，右孩子为数组的下一个结点
class Solution(object):
    def flatten(self, root):

        def preorder(root):
            if root:
                res.append(root)
                preorder(root.left)
                preorder(root.right)

        if not root:
            return
        global res
        res = []
        preorder(root)
        for i in range(len(res)-1):
            res[i].left = None
            res[i].right = res[i+1]
        res[-1].left = None
        res[-1].right = None

# 方法二：复制左右子树，裁剪左子树，将左子树拼接到根与右子树中间
class Solution(object):
    def flatten(self, root):
        if not root:
            return
        left_node = root.left
        right_node = root.right
        root.left = None
        self.flatten(left_node)
        self.flatten(right_node)
        if left_node:
            root.right = left_node
            while left_node.right:
                left_node = left_node.right
            left_node.right = right_node