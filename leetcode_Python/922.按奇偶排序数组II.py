# 方法一：分别提取奇偶元素，再间隔插入原数组
class Solution(object):
    def sortArrayByParityII(self, A):
        even, odd = [], []
        for i in A:
            if i%2==0:
                even.append(i)
            else:
                odd.append(i)
        A[::2] = even
        A[1::2] = odd
        return A

# 方法二：使用zip
class Solution(object):
    def sortArrayByParityII(self, A):
        even = [i for i in A if not i%2]
        odd = [i for i in A if i%2]
        return [i for z in zip(even, odd) for i in z]