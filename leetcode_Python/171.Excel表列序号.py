# 26进制转10进制。正序
class Solution(object):
    def titleToNumber(self, s):
        res = 0
        for i in range(len(s)):
            res += (26**(len(s)-i-1)) * (ord(s[i])-ord('A')+1)
        return int(res)

# 逆序
class Solution(object):
    def titleToNumber(self, s):
        S = list(s)
        S.reverse()
        res = 0
        for i, v in enumerate(S):
            res += (26**i) * (ord(v)-ord('A')+1)
        return res