# 输入是一个无符号整数，要先转化为二进制形式，再转为字符串形式统计1的个数
class Solution(object):
    def hammingWeight(self, n):
        return bin(n).count('1')