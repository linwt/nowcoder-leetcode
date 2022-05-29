# 计算连续的0,1的个数有多少，构成一个数组，找出相邻的两个个数的最小值，然后累加求和
class Solution(object):
    def countBinarySubstrings(self, s):
        s = map(len, s.replace('01', '0 1').replace('10', '1 0').split())
        return sum(min(i, j) for i, j in zip(s, s[1:]))