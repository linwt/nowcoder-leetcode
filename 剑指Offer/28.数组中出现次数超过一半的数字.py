# 方法一：使用列表的count()方法统计次数
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        items = list(set(numbers))
        for i in items:
            if numbers.count(i) > len(numbers)/2:
                return i
        return 0

# 方法二：使用字典统计次数
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        if not numbers:
            return 0
        d = dict()
        for i in numbers:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for k in d:
            if d[k] > len(numbers)/2:
                return k
        return 0