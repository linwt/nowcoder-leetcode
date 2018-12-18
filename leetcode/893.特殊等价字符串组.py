# 使用字典
class Solution(object):
    def numSpecialEquivGroups(self, A):
        d = {}
        for s in A:
            odd = [s[i] for i in range(0, len(s), 2)]
            even = [s[i] for i in range(1, len(s), 2)]
            odd.sort()
            even.sort()
            d[''.join(odd + even)] = 1
        return len(d)

# 使用集合
class Solution(object):
    def numSpecialEquivGroups(self, A):
        res = set()
        for s in A:
            odd = [s[i] for i in range(0, len(s), 2)]
            even = [s[i] for i in range(1, len(s), 2)]
            odd.sort()
            even.sort()
            res.add(''.join(odd + even))
        return len(res)