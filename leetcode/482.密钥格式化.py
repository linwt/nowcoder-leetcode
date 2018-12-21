# 方法一：从后往前遍历，每K个字符添加1个'-'，再判断最后是否刚好满K个多加了1个'-'，若有需要去掉
class Solution(object):
    def licenseKeyFormatting(self, S, K):
        res = ''
        count = 0
        for s in reversed(S):
            if s != '-':
                res += s.upper()
                count += 1
                if count == K:
                    res += '-'
                    count = 0
        if res and res[-1] == '-':
            res = res[:-1]
        return res[::-1]

# 方法二：将'-'以外的全部字符个数与K取余计算得出第一组字符的个数，其他则每K个一组
class Solution(object):
    def licenseKeyFormatting(self, S, K):
        res = []
        s = ''.join(S.split('-')).upper()
        N = len(s)
        if N%K != 0:
            res.append(s[:N%K])
        for i in range(N%K, N, K):
            res.append(s[i:i+K])
        return '-'.join(res)
