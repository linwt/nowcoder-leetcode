class Solution(object):
    def permuteUnique(self, nums):
        def find(nums, output):
            if not nums and output not in res:
                res.append(output)
                return
            for i in range(len(nums)):
                find(nums[:i] + nums[i+1:], output + [nums[i]])

        res = []
        find(nums, [])
        return res