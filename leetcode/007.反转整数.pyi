# 直接判断正负两种情况
class Solution(object):
    def reverse(self, x):
        x = -int(str(x)[::-1][:-1]) if x<0 else int(str(x)[::-1])
        return x if abs(x)<0x7FFFFFFF else 0
        # return x if -2**31<=x<=2**31-1 else 0

# 标记正负两种情况
class Solution(object):
    def reverse(self, x):
        sign = 1 if x>0 else -1
        x = sign * int(str(abs(x))[::-1])
        return x if abs(x)<0x7FFFFFFF else 0