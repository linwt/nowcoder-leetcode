# 增时添加左边一个数，减时添加右边一个数，遍历完S再添加最后剩下的一个数
class Solution(object):
    def diStringMatch(self, S):
        res = []
        l, r = 0, len(S)
        for s in S:
            if s == 'I':
                res.append(l)
                l += 1
            if s == 'D':
                res.append(r)
                r -= 1
        res.append(l)
        return res