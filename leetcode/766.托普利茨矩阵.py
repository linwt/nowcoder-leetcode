# 方法一：当前行去掉首元素，上一行去掉尾元素，比较两个数组是否相等
class Solution(object):
    def isToeplitzMatrix(self, matrix):
        for i in range(1, len(matrix)):
            if matrix[i][1:] != matrix[i-1][:-1]:
                return False
        return True

# 方法二：遍历每个元素，如果该元素与右下角元素不相等，则为False
class Solution(object):
    def isToeplitzMatrix(self, matrix):
        for i in range(len(matrix)-1):
            for j in range(len(matrix[0])-1):
                if matrix[i][j] != matrix[i+1][j+1]:
                    return False
        return True