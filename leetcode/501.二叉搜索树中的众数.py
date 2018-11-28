# 获取所有节点的值，再求众数
import collections
class Solution(object):
    def findMode(self, root):
        if not root:
            return []

        # 中序遍历，得到结点值数组
        def inorder(root):
            if root:
                inorder(root.left)
                l.append(root.val)
                inorder(root.right)

        l = []
        inorder(root)
        # 得到一个字典，每个结点值与其对应个数
        c = collections.Counter(l)
        mode = max(c.values())
        res = []
        for key in c:
            if c[key]==mode:
                res.append(key)
        return res