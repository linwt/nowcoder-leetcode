# 将字符串拆成当个数字相加，判断结果长度是否大于1，循环此过程
class Solution(object):
    def addDigits(self, num):
        while len(str(num)) > 1:
            num = sum(map(int, [i for i in str(num)]))
        return num