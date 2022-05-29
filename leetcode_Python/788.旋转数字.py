# 包含‘2569’其一，且不包含‘347’
class Solution(object):
    def rotatedDigits(self, N):
        res = 0
        for i in range(1, N+1):
            s = str(i)
            if ('2' in s or '5' in s or '6' in s or '9' in s) and ('3' not in s and '4' not in s and '7' not in s):
                res += 1
        return res