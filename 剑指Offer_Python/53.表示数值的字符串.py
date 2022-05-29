# 能表示数值的字符串能够转为浮点类型，否则抛异常
class Solution:
    def isNumeric(self, s):
        try:
            float(s)
            return True
        except:
            return False