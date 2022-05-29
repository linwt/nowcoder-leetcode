# 斐波那契数列：1,1,2,3,5,8,12

# 方法一：递推，数组追加
class Solution:
    def Fibonacci(self, n):
        a = [0, 1, 1]
        if n < 3:
            return a[n]
        for i in range(3, n+1):
            a.append(a[i-1] + a[i-2])
        return a[n]

# 方法二：递推，赋值
class Solution:
    def Fibonacci(self, n):
        f0, f1 = 0, 1
        if n == 0:
            return f0
        if n == 1:
            return f1
        for i in range(2, n+1):
            f0, f1 = f1, f0+f1
        return f1

# 方法三：递归
class Solution:
    # 方法的作用：返回前两个数的和
    def Fibonacci(self, n):
        # 终止条件
        if n==0:
            # 处理方法
            return 0
        if n==1:
            return 1
        # 提取重复逻辑，调用自身解决相同的问题
        return self.Fibonacci(n-1) + self.Fibonacci(n-2)