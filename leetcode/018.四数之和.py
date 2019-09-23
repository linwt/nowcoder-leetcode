# 数组排序后，先固定两个数，再用双指针从头尾向内移动确定另外两个数
class Solution(object):
    def fourSum(self, nums, target):
        n = len(nums)
        nums.sort()
        res = set()
        for i in range(n-3):
            for j in range(i+1, n-2):
                l, r = j+1, n-1
                while l < r:
                    temp = nums[i] + nums[j] + nums[l] + nums[r]
                    if temp == target:
                        # 去重
                        res.add((nums[i], nums[j], nums[l], nums[r]))
                        l += 1
                        r -= 1
                    # 结果比目标值大，右指针左移减小数值
                    if temp > target:
                        r -= 1
                    # 结果比目标值小，左指针右移增大数值
                    if temp < target:
                        l += 1
        return [list(t) for t in res]