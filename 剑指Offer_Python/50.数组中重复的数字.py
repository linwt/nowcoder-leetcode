# 方法一：列表的count()方法
class Solution:
    # 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
    # 函数返回True/False
    def duplicate(self, numbers, duplication):
        for i in numbers:
            if numbers.count(i)>1:
                duplication[0] = i
                return True
        return False

# 方法二：集合的Counter对象，返回键值对，键是元素，值是元素个数
import collections
class Solution:
    def duplicate(self, numbers, duplication):
        c = collections.Counter(numbers)
        for value,num in c.items():
            if num>1:
                duplication[0] = value
                return True
        return False