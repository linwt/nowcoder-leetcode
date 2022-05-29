# 方法一：遍历集合，边统计元素的个数
class Solution(object):
    def repeatedNTimes(self, A):
        n = len(A)/2
        for i in A:
            if A.count(i) == n:
                return i

# 方法二：利用字典存放字符与对应个数
class Solution(object):
    def repeatedNTimes(self, A):
        d = collections.Counter(A)
        n = len(A)/2
        for i in set(A):
            if d[i] == n:
                return i