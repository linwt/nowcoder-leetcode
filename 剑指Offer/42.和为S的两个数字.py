# 递增排序的数组，所以第一对的乘积就是最小的
class Solution:
    def FindNumbersWithSum(self, array, tsum):
        for i in array:
            if tsum-i in array:
                return [i, tsum-i]
        return []