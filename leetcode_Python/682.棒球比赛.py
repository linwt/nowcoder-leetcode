# 用数组添加、删除数据即可，最后求和
class Solution(object):
    def calPoints(self, ops):
        res = []
        for op in ops:
            if op == '+':
                res.append(res[-1] + res[-2])
            elif op == 'D':
                res.append(res[-1] * 2)
            elif op == 'C':
                res.remove(res[-1])
            else:
                res.append(int(op))
        return sum(res)