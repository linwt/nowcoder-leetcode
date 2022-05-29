# 遍历数组，用一个长度为k的列表存放最大的k个数，返回列表中的最小值即为第k大的数
class Solution(object):
    def findKthLargest(self, nums, k):
        res = []
        for num in nums:
            if len(res) < k:
                res.append(num)
            elif num > min(res):
                res[res.index(min(res))] = num
        return min(res)