# 整型列表转化为数字，加1后再转化为整型列表
class Solution(object):
    def plusOne(self, digits):
        num = int(''.join(str(i) for i in digits)) + 1
        new_digits = []
        for i in str(num):
            new_digits.append(int(i))
        return new_digits