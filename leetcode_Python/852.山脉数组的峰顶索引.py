# 方法一：已经确定为山脉的数组，找最大值的索引即可
class Solution(object):
    def peakIndexInMountainArray(self, A):
        return A.index(max(A))

# 方法二：遍历数组得到第一个出现递减的值的索引
class Solution(object):
    def peakIndexInMountainArray(self, A):
        for i in range(1, len(A)-1):
            if A[i] > A[i+1]:
                return i

