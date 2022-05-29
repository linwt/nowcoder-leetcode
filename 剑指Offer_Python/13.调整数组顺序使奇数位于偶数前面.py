# 方法一：使用一个数组
class Solution:
    def reOrderArray(self, array):
        l = []
        for i in range(len(array)):
            # 逆序访问，是奇数则插到数组第一位
            if array[-1-i]%2 != 0:
                l.insert(0, array[-1-i])
            # 顺序访问，是偶数则追加到数组后面
            if array[i]%2 == 0:
                l.append(array[i])
        return l

# 方法二：使用两个数组，分别存放奇数和偶数
class Solution:
    def reOrderArray(self, array):
        a = [x for x in array if x%2]
        b = [x for x in array if not x%2]
        return a+b