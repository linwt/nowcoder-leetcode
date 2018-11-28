# 方法一：用数组存放中序遍历结果
class Solution(object):
    def __init__(self):
        self.res = []

    def kthSmallest(self, root, k):
        self.inorder(root)
        return self.res[k-1]

    def inorder(self, root):
        if not root:
            return
        self.inorder(root.left)
        self.res.append(root.val)
        self.inorder(root.right)

# 方法二：
# 如果root的左子树结点数量是k-1，那么root就刚好是第k个
# 如果k小于左子树结点数量，则递归判断root.left
# 如果k大于左子树结点数量，则递归判断root.right，k减去左子树和根的结点个数
class Solution(object):
    def kthSmallest(self, root, k):
        def count(root):
            if not root:
                return 0
            return count(root.left) + count(root.right) + 1

        if not root:
            return
        left = count(root.left)
        if left == k-1:
            return root.val
        elif left > k-1:
            return self.kthSmallest(root.left, k)
        else:
            return self.kthSmallest(root.right, k-left-1)