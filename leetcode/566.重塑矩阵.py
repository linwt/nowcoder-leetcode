# 先将矩阵所有值添加到数组中，再将数组中的值添加到新的矩阵中
class Solution(object):
    def matrixReshape(self, nums, r, c):
        row = len(nums)
        col = len(nums[0])

        if row*col < r*c:
            return nums

        t = []
        for i in range(row):
            for j in range(col):
                t.append(nums[i][j])

        res = []
        m = 0
        for i in range(r):
            res.append(t[m:m+c])
            m += c
        return res