# 每次先初始化当前行的数组，再将求和结果代入
class Solution(object):
    def generate(self, numRows):
        res = []
        for i in range(numRows):
            cur = [1]*(i+1)
            if i >= 2:
                for j in range(1, i):
                    cur[j] = pre[j] + pre[j-1]
            res.append(cur)
            pre = cur
        return res