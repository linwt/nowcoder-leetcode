class Solution(object):
    def allPossibleFBT(self, N):
        N -= 1
        if N == 0:
            return [TreeNode(0)]
        res = []
        for i in range(1, N, 2):
            for left in self.allPossibleFBT(i):
                for right in self.allPossibleFBT(N - i):
                    node = TreeNode(0)
                    node.left = left
                    node.right = right
                    res.append(node)
        return res

##################### 递归思路 #######################
# 方法作用极简化：先判断1个结点和3个结点的情况
# 方法作用描述：参数给一个结点数N，将N个结点组合成树，然后返回根结点
# 递归：由于左右子树需要同样操作，使用递归。
# 由于左右子树结点数目、类型可变，使用两重for循环
class Solution(object):
    def allPossibleFBT(self, N):
        N -= 1
        if N == 0:
            return [TreeNode(0)]
        res = []
        node = TreeNode(0)
        node.left = TreeNode(0)
        node.right = TreeNode(0)
        res.append(node)
        return res