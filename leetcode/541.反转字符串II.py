# 每隔k个字符就翻转k个字符
class Solution(object):
    def reverseStr(self, s, k):
        n = len(s)
        for i in range(0, n, 2*k):
            # 剩余少于 k 个字符，全部翻转
            if i + k >= n:
                s = s[:i] + s[i:][::-1]
            # 剩余多于于 k 个字符，翻转 k 个字符
            else:
                s = s[:i] + s[i:i+k][::-1] + s[i+k:]
        return s