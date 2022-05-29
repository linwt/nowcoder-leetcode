# 用字典存储遍历过的值和索引
class Solution(object):
    def twoSum(self, numbers, target):
        d = dict()
        for index, value in enumerate(numbers):
            sub = target - value
            if sub in d.keys():
                return [d[sub]+1, index+1]
            d[value] = index