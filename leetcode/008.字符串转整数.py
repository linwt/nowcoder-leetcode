# 逐个条件进行判断
class Solution(object):
    def myAtoi(self, s):
        s = s.strip()
        if len(s)==0:
            return 0

        s0 = s[0]
        res, sign = 0, 1
        if s0=='+' or s0=='-':
            if s0=='-':
                sign = -1
            s = s[1:]
        for i in s:
            if i>='0' and i<='9':
                res = res*10+int(i)
            else:
                break

        if res>2147483647:
            if sign==1:
                return 2147483647
            else:
                return -2147483648
        return sign*res