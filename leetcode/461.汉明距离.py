# 异或，其二进制同0异1，再将十进制的异或结果转为二进制，求1的个数
class Solution(object):
    def hammingDistance(self, x, y):
        return bin(x^y).count('1')