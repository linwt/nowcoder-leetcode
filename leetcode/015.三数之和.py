# 数组排序后，先固定一个数，再用双指针从头尾向内移动确定另外两个数
class Solution(object):
    def threeSum(self, nums):
        n = len(nums)
        nums.sort()
        res = set()
        for i in range(n-2):
            x, y = i+1, n-1
            while x < y:
                if nums[i] + nums[x] + nums[y] == 0:
                    # 去重
                    res.add((nums[i], nums[x], nums[y]))
                    x += 1
                    y -= 1
                if nums[i] + nums[x] + nums[y] > 0:
                    y -= 1
                if nums[i] + nums[x] + nums[y] < 0:
                    x += 1
        # 还原为列表
        return [list(l) for l in res]