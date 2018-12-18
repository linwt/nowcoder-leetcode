# 转化为十进制求和，再将结果转为二进制，要去除开头的‘0b’
class Solution(object):
    def addBinary(self, a, b):
        return bin(int(a, 2) + int(b, 2))[2:]