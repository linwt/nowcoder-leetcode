# 类似阶乘
class Solution:
    def Sum_Solution(self, n):
        if n == 1:
            return 1
        return self.Sum_Solution(n-1) + n