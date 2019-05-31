class Solution(object):
    def subsetsWithDup(self, nums):
        def find(nums, output):
            if sorted(output) not in res:
                res.append(sorted(output))
            for i in range(len(nums)):
                find(nums[i+1:], output + [nums[i]])

        res = []
        find(nums, [])
        return res