# 方法一：若同构则查找字符的索引相同
class Solution(object):
    def isIsomorphic(self, s, t):
        for i in range(len(s)):
            if s.find(s[i]) != t.find(t[i]):
                return False
        return True

# 方法二：判断两字符串去重 与 压缩再去重的长度是否相同
class Solution(object):
    def isIsomorphic(self, s, t):
        if len(s) != len(t):
            return False
        return len(set(zip(s, t))) == len(set(s)) == len(set(t))