# 先用字典存放nums中每个元素后第一个比它大的值，再遍历findNums的元素从字典获取该值
class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        l = []
        d = {}
        for num in nums:
            while l and l[-1] < num:
                d[l.pop()] = num
            l.append(num)
        for i in range(len(findNums)):
            findNums[i] = d.get(findNums[i], -1)
        return findNums