class Solution(object):

    def __init__(self):
        self.maxLen = 0

    def longestUnivaluePath(self, root):
        if not root:
            return 0
        self.getMaxLen(root, root.val)
        return self.maxLen

    # 由左右最长同值路径相加
    def getMaxLen(self, root, val):
        if not root:
            return 0
        left = self.getMaxLen(root.left, root.val)
        right = self.getMaxLen(root.right, root.val)
        self.maxLen = max(self.maxLen, left + right)
        if root.val == val:
            return max(left, right) + 1
        return 0