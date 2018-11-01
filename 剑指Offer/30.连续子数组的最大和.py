# 方法一：遍历数组每个值作为起点，每次不断加后面的值，使用数组存放每次求和的结果，最终排序取最大值
class Solution:
    def FindGreatestSumOfSubArray(self, array):
        l = []
        for i in range(len(array)):
            maxSum = array[i]
            l.append(maxSum)
            for j in range(i+1, len(array)):
                maxSum += array[j]
                l.append(maxSum)
        l.sort()
        return l[-1]

# 方法二：往后累加，得到更大的值则保存，若累加结果小于0则重新设置起点
class Solution:
    def FindGreatestSumOfSubArray(self, array):
        maxSum, curSum = 0, 0
        maxN = max(array)
        if maxN < 0:
            return maxN
        for i in range(len(array)):
            curSum += array[i]
            if curSum > maxSum:
                maxSum = curSum
            # 小于0则前面部分负大于正，重新设置子序列起点
            if curSum < 0:
                curSum = 0
        return maxSum