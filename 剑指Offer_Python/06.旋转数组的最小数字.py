# 方法一：min()函数
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        if not rotateArray:
            return 0
        return min(rotateArray)

# 方法二：sorted()函数
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        if not rotateArray:
            return 0
        r = sorted(rotateArray)
        return r[0]

# 方法三：sort()方法
class Solution:
    def minNumberInRotateArray(self, rotateArray):
        if not rotateArray:
            return 0
        rotateArray.sort()
        return rotateArray[0]