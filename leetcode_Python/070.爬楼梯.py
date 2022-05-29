# 规律：1,2,3,5,8
# 方法一：递推
class Solution(object):
    def climbStairs(self, n):
        if n<3:
            return n
        a, b = 1, 2
        while n>2:
            a, b = b, a+b
            n -= 1
        return b

# 方法二：递归
class Solution(object):
    def climbStairs(self, n):
        if n in [1, 2]:
            return n
        return self.climbStairs(n-1) + self.climbStairs(n-2)

# 方法三：动态规划
class Solution(object):
    def climbStairs(self, n):
        res = [1] * (n+1)
        for i in range(2, n+1):
            res[i] = res[i-1] + res[i-2]
        return res[-1]