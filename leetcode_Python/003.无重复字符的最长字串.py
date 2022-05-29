# 滑动窗口，遇到重复的字符就从该字符下一位开始计算
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        d = {}
        start = res = 0
        for i, v in enumerate(s):
            if v in d:
                start = max(start, d[v]+1)
            d[v] = i
            res = max(res, i-start+1)
        return res