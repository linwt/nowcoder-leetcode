class Solution(object):
    def maxPathSum(self, root):
        if not root:
            return 0
        self.res = root.val
        self.findmax(root)
        return self.res

    def findmax(self, root):
        if not root:
            return 0
        left = self.findmax(root.left)
        max_left = left if left>0 else 0
        right = self.findmax(root.right)
        max_right = right if right>0 else 0
        self.res = max(self.res, max_left + max_right + root.val)
        return max(max_left, max_right) + root.val

##################### 递归思路 #######################
# 方法作用极简化：先判断无结点和1个结点的情况
# 方法作用描述：参数给一个结点，将结点值与结果值比较取最大保存，然后返回该结点值
# 递归：由于需要累加左右子树结点值，使用递归得到每个结点的值并将结果累加
def findmax(self, root):
    if not root:
        return 0
    self.res = max(self.res, root.val)
    return root.val