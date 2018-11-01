# 字符串是合法数值时可转换为整数，否则抛异常
class Solution:
    def StrToInt(self, s):
        try:
            return int(s)
        except:
            return 0