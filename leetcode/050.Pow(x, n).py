# 折半计算，每次将n缩小一半
class Solution(object):
    def myPow(self, x, n):
        if n < 0:
            n, x = abs(n), 1/x
        res = 1
        while n:
            # n为奇数则需要乘一个x
            if n % 2:
                res *= x
            # x翻倍
            x *= x
            # n缩小一半
            n //= 2
        return res