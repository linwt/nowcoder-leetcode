# 方法一：字符串比较并排序
class Solution:
    def PrintMinNumber(self, numbers):
        num = map(str, numbers)
        num.sort(lambda x, y: cmp(x+y, y+x))
        return ''.join(num)

# 方法二：排列组合后求最小值
import itertools
class Solution:
    def PrintMinNumber(self, numbers):
        if not numbers:
            return ''
        num = map(str, numbers)
        l = itertools.permutations(num)
        return min(map(int,[''.join(i) for i in l]))