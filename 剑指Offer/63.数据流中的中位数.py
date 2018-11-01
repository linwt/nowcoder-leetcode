# 用全局数组存放数据
class Solution:
    def __init__(self):
        self.data = []
    def Insert(self, num):
        self.data.append(num)
        self.data.sort()
    def GetMedian(self, data):
        length = len(self.data)
        if length%2 == 0:
            return (self.data[length/2]+self.data[length/2-1])/2.0
        else:
            return self.data[length/2]