# 方法一：使用数组添加删除数字，出现偶数次的数字最终会被删除
class Solution:
    def FindNumsAppearOnce(self, array):
        a = []
        for i in array:
            if i not in a:
                a.append(i)
            else:
                a.remove(i)
        return a

# 方法二：使用count()方法统计出现1次的数字
class Solution:
    def FindNumsAppearOnce(self, array):
        a = []
        for i in array:
            if array.count(i)==1:
                a.append(i)
        return a

# 方法二：使用字典统计数字出现的次数，返回出现1次的数字
class Solution:
    def FindNumsAppearOnce(self, array):
        d = {}
        for i in array:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        res = [i for i in d if d[i]==1]
        return res