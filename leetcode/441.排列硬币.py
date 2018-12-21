# 每增加一行，当前总硬币数增加该行的行号，当前总硬币数小于等于n时循环，大于时则上一行的行号即为所求总行数
class Solution(object):
    def arrangeCoins(self, n):
        i = nums = 0
        while nums <= n:
            i += 1
            nums += i
        return i-1