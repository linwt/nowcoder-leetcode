# 回溯法，先算出全部全排列，再取第k个
class Solution(object):
    def getPermutation(self, n, k):
        def gen(output, nums):
            if not nums:
                res.append(output)
            for i in range(len(nums)):
                gen(output + str(nums[i]), nums[:i] + nums[i+1:])

        res = []
        nums = [i for i in range(1, n+1)]
        gen('', nums)
        return res[k-1]


# 找规律，一位一位地组合数字
import math
class Solution(object):
    def getPermutation(self, n, k):
        nums = [str(i) for i in range(1, n+1)]
        res = ''
        n -= 1
        while n >= 0:
            # n个数，以每一位数字开头有(n-1)!个排列
            fac_n = math.factorial(n)

            # 确定n个数中第k个排列的第一位数的位置，向上取整再减1，该行等于以下四行
            loc = math.ceil(k / fac_n) - 1
            # if k % fac_n:
            #     loc = k // fac_n
            # else:
            #     loc = k // fac_n - 1

            res += nums[loc]
            nums.pop(loc)
            # 确定了前一位数后，k减去前面已排除的多个(n-1)!全排列
            k %= fac_n
            n -= 1
        return res