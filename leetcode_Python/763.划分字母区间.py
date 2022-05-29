# 获取每个字母的最大索引存入字典，遍历每个字母得到区间最大长度
class Solution(object):
    def partitionLabels(self, S):
        d = {}
        for i, v in enumerate(S):
            d[v] = i
        left, right, res = 0, d[S[0]], []
        for i, v in enumerate(S):
            right = max(right, d[v])
            if i >= right:
                res.append(right - left + 1)
                left = right + 1
        return res