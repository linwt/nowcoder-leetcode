from collections import Counter
class Solution(object):
    def topKFrequent(self, nums, k):
        # {1: 3, 2: 2, 3: 1}  →  [(1, 3), (2, 2)]
        return [item[0] for item in Counter(nums).most_common(k)]

s = Solution()
nums = [1,1,1,2,2,3]
k = 2
res = s.topKFrequent(nums, k)
print(res)