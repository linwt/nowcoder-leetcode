# 所有不快乐数的数位平方和计算，最后都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
class Solution(object):
    def isHappy(self, n):
        while n != 1:
            n = sum(map(lambda x: x**2, map(int, str(n))))
            if n == 4:
                return False
        return True