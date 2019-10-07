# 分治法
class Solution(object):
    def longestSubstring(self, s, k):
        if not s:
            return 0
        # 遍历字符串去重后的字符
        for c in set(s):
            # 如果字符个数少于k
            if s.count(c) < k:
                # 按照该字符拆分字符串，再递归求出拆分后的字串中最长的字串
                return max(self.longestSubstring(t, k) for t in s.split(c))
        # 每个字符的个数都大于等于k，则返回字符串的长度
        return len(s)