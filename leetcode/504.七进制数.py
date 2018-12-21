# 除基取余，得到七进制数，再判断正负加上符号
class Solution(object):
    def convertToBase7(self, num):
        if not num:
            return '0'
        res = ''
        n = abs(num)
        while n > 0:
            res += str(n%7)
            n /= 7
        if num < 0:
            res += '-'
        return res[::-1]