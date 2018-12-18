# 使用字典存放值与个数
import collections
class Solution(object):
    def firstUniqChar(self, s):
        d = collections.Counter(s)
        for i, v in enumerate(s):
            if d[v] == 1:
                return i
        return -1