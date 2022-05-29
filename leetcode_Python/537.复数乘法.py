# 提取出数字，计算实部和虚部的值
class Solution(object):
    def complexNumberMultiply(self, a, b):
        num1 = map(int, a[:-1].split('+'))
        num2 = map(int, b[:-1].split('+'))
        real = num1[0] * num2[0] - num1[1] * num2[1]
        vir = num1[1] * num2[0] + num1[0] * num2[1]
        return '%d+%di' %(real, vir)