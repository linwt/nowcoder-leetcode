# 因子可全由2组成，除尽2判断最终结果是否等于1
class Solution(object):
    def isPowerOfTwo(self, n):
        if n==0:
            return False
        while n%2 == 0:
            n /= 2
        return n == 1