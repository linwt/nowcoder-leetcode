# 峰顶左边递增，右边递减，且左右不含重复元素
class Solution(object):
    def validMountainArray(self, A):
        if not A:
            return False
        i = A.index(max(A))
        return i!=0 and i!=len(A)-1 and sorted(set(A[:i])) == A[:i] and sorted(set(A[i:]))[::-1] == A[i:]