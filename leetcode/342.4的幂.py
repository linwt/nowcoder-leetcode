# 因子可全由4组成，除尽4判断最终结果是否等于1
class Solution(object):
    def isPowerOfFour(self, num):
        if num==0:
            return False
        while num%4 == 0:
            num /= 4
        return num == 1