# 方法一：遍历s，在t中移除遍历到的元素，最后剩下一个就是添加的字母
class Solution(object):
    def findTheDifference(self, s, t):
        t = list(t)
        for i in s:
            t.remove(i)
        return t[0]

# 方法二：遍历t，统计t与s中该字符的个数，若不相同则为添加的字母
class Solution(object):
    def findTheDifference(self, s, t):
        for i in t:
            if t.count(i) != s.count(i):
                return i