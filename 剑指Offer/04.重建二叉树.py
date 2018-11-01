class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 方法作用：由前序和中序遍历序列得到根的左子树和右子树
    def reConstructBinaryTree(self, pre, tin):
        # 终止条件
        if not pre:
            # 处理方法
            return None
        root = TreeNode(pre[0])
        i = tin.index(pre[0])
        # 提取重复逻辑
        root.left = self.reConstructBinaryTree(pre[1:i+1], tin[:i])
        root.right = self.reConstructBinaryTree(pre[i+1:], tin[i+1:])
        return root