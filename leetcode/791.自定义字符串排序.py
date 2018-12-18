# 统计T中字符的个数用字典存放,。先遍历S，按照字典中个数将字符添加到新字符串，并将个数计为0。再遍历T，将剩余字符添加到新字符串
class Solution(object):
    def customSortString(self, S, T):
        count = collections.Counter(T)
        res = ''
        for s in S:
            res += s * count[s]
            count[s] = 0
        for c in count:
            res += c * count[c]
        return res