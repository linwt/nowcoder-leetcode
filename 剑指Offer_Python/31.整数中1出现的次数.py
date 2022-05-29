# 方法一：判断整数每个数字
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        count = 0
        for i in range(1, n+1):
            temp = i
            while(temp):
                if temp%10 == 1:
                    count += 1
                temp /= 10
        return count

# 方法二：将整数转为字符串逐位判断
class Solution:
    def NumberOf1Between1AndN_Solution(self, n):
        count = 0
        for i in range(1, n+1):
            s = str(i)
            for j in s:
                if j == '1':
                    count += 1
        return count

# 方法三：将整数转为字符串，组合含有‘1’的字符串，再统计‘1’的个数
def NumberOf1Between1AndN_Solution(self, n):
    a = map(str, range(n+1))
    ones = [i for i in a if '1' in i]
    return ''.join(ones).count('1')