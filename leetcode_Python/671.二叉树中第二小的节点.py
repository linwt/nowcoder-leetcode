# 由题可知，根结点是最小的结点，则左右子树中节点值不等于根节点值的所有节点中，值最小的即为第二小的值
class Solution(object):
    def findSecondMinimumValue(self, root):
        if not root or not root.left:
            return -1
        return self.find(root, root.val)

    def find(self, root, minVal):
        if not root.left:
            return -1 if root.val == minVal else root.val
        leftMin = self.find(root.left, minVal)
        rightMin = self.find(root.right, minVal)
        if leftMin == -1 or rightMin == -1:
            return max(leftMin, rightMin)
        return min(leftMin, rightMin)