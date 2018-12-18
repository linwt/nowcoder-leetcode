# 方法一：遍历统计连续1的个数，并更新最大值
class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        max_count = count = 0
        for num in nums:
            if num == 1:
                count += 1
                max_count = max(max_count, count)
            else:
                count = 0
        return max_count

# 方法二：按0切分出1的子串，计算最大长度
class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        return len(max(''.join(map(str, nums)).split('0')))