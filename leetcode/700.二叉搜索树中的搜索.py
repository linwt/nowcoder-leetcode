# 左边结点都比根结点小，右边结点都比根结点大
class Solution(object):
    def searchBST(self, root, val):
        if not root:
            return
        if root.val == val:
            return root
        elif root.val > val:
            return self.searchBST(root.left, val)
        else:
            return self.searchBST(root.right, val)