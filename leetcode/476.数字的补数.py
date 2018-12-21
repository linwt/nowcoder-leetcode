# 方法一：判断字符，添加相反字符
class Solution(object):
    def findComplement(self, num):
        res = ''
        for i in str(bin(num)[2:]):
            if i == '1':
                res += '0'
            else:
                res += '1'
        return int(res, 2)

# 方法二：逐位异或
class Solution(object):
    def findComplement(self, num):
        res = ''
        for i in bin(num)[2:]:
            res += str(int(i)^1)
        return int(res, 2)