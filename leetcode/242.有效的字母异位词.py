# 使用字典，判断两个字符串中字符的个数是否相同
class Solution(object):
    def isAnagram(self, s, t):
        s = collections.Counter(s)
        t = collections.Counter(t)
        return s == t

# 排序
class Solution(object):
    def isAnagram(self, s, t):
        return sorted(s) == sorted(t)