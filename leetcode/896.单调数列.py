# 方法一：排序，比较与正反排序结果是否相等
class Solution(object):
    def isMonotonic(self, A):
        if A == sorted(A) or A == sorted(A)[::-1]:
            return True
        return False

# 方法二：设置标志，遍历数组，不满足条件者设为False，返回两者其一
class Solution(object):
    def isMonotonic(self, A):
        up = down = True
        for i in range(len(A)-1):
            if A[i] > A[i+1]:
                up = False
            if A[i] < A[i+1]:
                down = False
        return up or down