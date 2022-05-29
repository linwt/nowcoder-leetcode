# 贪心算法
class Solution(object):
    def wiggleMaxLength(self, nums):
        # 边界条件
        n = len(nums)
        if n < 2:
            return n

        # 以正/负结尾时的最长摆动序列长度
        up = down = 1
        # 正负性相同则长度不变，相反则加1
        for i in range(1, n):
            if nums[i-1] < nums[i]:
                up = down + 1
            if nums[i-1] > nums[i]:
                down = up + 1
        return max(up, down)