# 判断字符串、列表去重 与 压缩再去重的长度是否相同
class Solution(object):
    def wordPattern(self, pattern, str):
        s = str.split()
        if len(pattern) != len(s):
            return False
        return len(set(zip(pattern, s))) == len(set(pattern)) == len(set(s))