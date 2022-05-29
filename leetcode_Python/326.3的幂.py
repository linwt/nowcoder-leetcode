# 因子可全由3组成，除尽3判断最终结果是否等于1
class Solution(object):
    def isPowerOfThree(self, n):
        if n==0:
            return False
        while n%3 == 0:
            n /= 3
        return n == 1