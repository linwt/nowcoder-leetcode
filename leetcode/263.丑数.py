# 丑数只包含质因数 2, 3, 5，将质因数除尽看结果是否为1
class Solution(object):
    def isUgly(self, num):
        if num <= 0:
            return False
        while num%2 == 0:
            num /= 2
        while num%3 == 0:
            num /= 3
        while num%5 == 0:
            num /= 5
        return num == 1