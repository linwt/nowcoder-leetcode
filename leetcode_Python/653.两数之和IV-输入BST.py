# 中序遍历得到结点值数组，再判断是否包含两数之和等于目标结果
class Solution(object):
    def findTarget(self, root, k):
        self.res = []
        def inorder(root):
            if root:
                inorder(root.left)
                self.res.append(root.val)
                inorder(root.right)
        inorder(root)
        for i,v in enumerate(self.res):
            if k-v in self.res[i+1:]:
                return True
        return False