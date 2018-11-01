# 方法一：使用栈
class Solution:
    def LastRemaining_Solution(self, n, m):
        if n < 1:
            return -1
        i = 0
        nums = range(n)
        while len(nums) > 1:
            i = (m - 1 + i) % len(nums)
            nums.pop(i)
        return nums[0]

# 方法二：使用两个数组，一个用于判断，一个用于删除指定元素
# 每一轮中一个数组用来判断出列的元素，另一个数组则删除该元素，一轮结束后将删除后的数组复制给判断的数组，进入新的一轮
class Solution:
    def LastRemaining_Solution(self, n, m):
        if n < 1:
            return -1
        a = [i for i in range(n)]
        b = a[:]
        count = 1
        while len(a)>1:
            for i in range(len(a)):
                if count%m == 0:
                    b.remove(a[i])
                count += 1
            a = b[:]
        return a[0]