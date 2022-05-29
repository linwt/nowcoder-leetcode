# 边移动边添加窗口中的最大值
class Solution:
    def maxInWindows(self, num, size):
        if not num or not size:
            return []
        a = []
        for i in range(len(num)-size+1):
            a.append(max(num[i:i+size]))
        return a