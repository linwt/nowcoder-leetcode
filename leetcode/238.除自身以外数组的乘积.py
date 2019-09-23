# 方法一：分类讨论
class Solution(object):
    def productExceptSelf(self, nums):
        z = nums.count(0)
        # 大于1个0的情况，累积结果全部为0
        if z > 1:
            return [0]*len(nums)
        # 1个0的情况，除了0位置，其他都为0
        if z == 1:
            res = [0]*len(nums)
            index = nums.index(0)
            nums.pop(index)
            r = 1
            for num in nums:
                r *= num
            res[index] = r
            return res
        # 没有0的情况，先算累积，再用总积去除逐个位置的数
        res = 1
        for num in nums:
            res *= num
        return [res/i for i in nums]


# 方法二：当前数 = 左边的乘积 x 右边的乘积
class Solution(object):
    def productExceptSelf(self, nums):
        n = len(nums)
        l, r, res = 1, 1, [1]*n
        for i in range(n):
            res[i] *= l
            l *= nums[i]
            res[n-1-i] *= r
            r *= nums[n-1-i]
        return res