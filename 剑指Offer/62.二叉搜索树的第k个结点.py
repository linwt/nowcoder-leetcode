# 中序遍历二叉搜索树，将遍历结点值存放在数组中，得到由小到大排序的数组
class Solution:
    def KthNode(self, pRoot, k):
        global res
        res = []
        self.midNode(pRoot)
        if k<=0 or len(res)<k:
            return None
        return res[k-1]
    def midNode(self, root):
        if not root:
            return None
        self.midNode(root.left)
        res.append(root)
        self.midNode(root.right)