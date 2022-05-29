# 一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到。
# 三个队列是有序的，所以取出三个头中最小的，即是新的丑数
class Solution:
    def GetUglyNumber_Solution(self, index):
        if index == 0:
            return 0
        res = [1]
        t2, t3, t5 = 0, 0, 0
        for i in range(index-1):
            new = min(res[t2]*2, res[t3]*3, res[t5]*5)
            res.append(new)
            if new%2 == 0:
                t2 += 1
            if new%3 == 0:
                t3 += 1
            if new%5 == 0:
                t5 += 1
        return res[-1]