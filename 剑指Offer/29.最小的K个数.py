# 方法一：使用sorted()函数
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        if k > len(tinput):
            return []
        t = sorted(tinput)
        return t[:k]

# 方法二：使用sort()方法
class Solution:
    def GetLeastNumbers_Solution(self, tinput, k):
        if k > len(tinput):
            return []
        tinput.sort()
        return tinput[:k]