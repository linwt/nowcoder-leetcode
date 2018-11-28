# 中序遍历，遍历数组看是否递增
class Solution(object):
    def isValidBST(self, root):
        global res
        res = []
        self.inOrder(root)
        for i in range(len(res)-1):
            if res[i] >= res[i+1]:
                return False
        return True
    def inOrder(self, root):
        if not root:
            return
        self.inOrder(root.left)
        res.append(root.val)
        self.inOrder(root.right)