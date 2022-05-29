# 将排序后字符串相同的字符串添加到字典数组中
class Solution(object):
    def groupAnagrams(self, strs):
        d = {}
        for s in strs:
            S = ''.join(sorted(list(s)))
            if S in d:
                d[S].append(s)
            else:
                d[S] = [s]
        return d.values()