class Solution(object):
    def findRelativeRanks(self, nums):
        nums2 = nums[:]
        nums2.sort(reverse=True)
        d = {}
        # 获取排序后的分数和名次，存入字典
        for i, v in enumerate(nums2):
            d[v] = str(i+1)

        # 前三名改变值
        d[nums2[0]] = 'Gold Medal'
        if len(nums2) > 1:
            d[nums2[1]] = 'Silver Medal'
        if len(nums2) > 2:
            d[nums2[2]] = 'Bronze Medal'

        # 遍历原数组，获取对应的值存入新数组
        res = []
        for num in nums:
            res.append(d[num])
        return res