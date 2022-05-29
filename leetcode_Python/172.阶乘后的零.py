# 找规律，将阶乘中的数分解成因子，有1个5则可以和前面分解出来的2搭配 2*5=10，则末尾就会有1个0
class Solution(object):
    def trailingZeroes(self, n):
        res = 0
        while n > 0:
            n /= 5
            res += n
        return res