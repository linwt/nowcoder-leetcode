# 与543题相似
# 方法一
class Solution(object):
    def findTilt(self, root):
        if not root:
            return 0
        # 对每一个结点求坡度
        return abs(self.nodeSum(root.left) - self.nodeSum(root.right)) + self.findTilt(root.left) + self.findTilt(root.right)

    # 求某结点为根时，该树的结点之和
    def nodeSum(self, root):
        if not root:
            return 0
        return root.val + self.nodeSum(root.left) + self.nodeSum(root.right)

# 方法二：边求坡度，边更新res的值
class Solution(object):
    def findTilt(self, root):
        self.res = 0
        def nodeSum(root):
            if not root:
                return 0
            left_sum = nodeSum(root.left)
            right_sum = nodeSum(root.right)
            self.res += abs(left_sum - right_sum)
            return root.val + left_sum + right_sum
        nodeSum(root)
        return self.res