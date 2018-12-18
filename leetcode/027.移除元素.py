# 将非val的值复制到数组前，最后一个复制完后，返回的索引即前面数组的长度
class Solution(object):
    def removeElement(self, nums, val):
        j = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[j] = nums[i]
                j += 1
        return j