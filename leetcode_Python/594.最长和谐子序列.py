# 相邻两个元素的出现次数最大和即为最长和谐子序列
class Solution(object):
    def findLHS(self, nums):
        d = collections.Counter(nums)
        l = sorted(list(set(nums)))
        count = 0
        for i in range(len(l)-1):
            if l[i]+1 == l[i+1] and d[l[i]] + d[l[i+1]] > count:
                count = d[l[i]] + d[l[i+1]]
        return count