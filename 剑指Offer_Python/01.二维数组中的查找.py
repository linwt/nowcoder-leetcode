# 方法一：逐行遍历
class Solution:
    def Find(self, target, array):
        for i in range(len(array)):
            if target in array[i]:
                return 'true'
        return 'false'

# 方法二：左下角开始遍历，大于向右，小于向上
class Solution:
    def Find(self, target, array):
        i, j = len(array)-1, 0
        while i>=0 and j<len(array[0]):
            temp = array[i][j]
            if target>temp:
                j += 1
            elif target<temp:
                i -= 1
            else:
                return 'true'
        return 'false'

while True:
    # try/cexept处理输入异常情况
    try:
        # 输入一个二维数组和一个整数
        # L = eval(raw_input())
        L = list(eval(raw_input()))
        target = L[0]
        array = L[1]
        S = Solution()
        print(S.Find(target, array))
    except:
        break

# 9,[[1,2,3],[4,5,6]]
# false
# 5,[[1,2,3],[4,5,6]]
# true



