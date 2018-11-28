# 动态规划：1到n都可以作为二叉搜索树的根节点，当k是根节点时，它的左边有k-1个不等的数，它的右边有n-k个不等的数
# 以k为根节点的二叉搜索树的种类就是左右可能的种类的乘积
class Solution(object):
    def numTrees(self, n):
        dp = [1 for i in range(n+1)]
        for i in range(2, n+1):
            s = 0
            for k in range(i):
                s += dp[k] * dp[i-k-1]
            dp[i] = s
        return dp[-1]