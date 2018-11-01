# 方法一：累乘
class Solution:
    def Power(self, base, exponent):
        if base == 0:
            return False
        if exponent == 0:
            return 1
        res = 1
        for i in range(abs(exponent)):
            res *= base
        if exponent < 0:
            return 1/res
        return res

# 方法二：使用pow()函数
class Solution:
    def Power(self, base, exponent):
        return pow(base, exponent)