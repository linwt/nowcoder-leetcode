# 方法一：使用replace()方法
class Solution:
    def replaceSpace(self, s):
        return s.replace(' ', '%20')

# 方法二：使用列表，元素赋值
class Solution:
    def replaceSpace(self, s):
        l = list(s)
        for i in range(len(l)):
            if l[i] == ' ':
                l[i] = '%20'
        return ''.join(l)

# 方法三：使用列表，添加元素
class Solution:
    def replaceSpace(self, s):
        a = []
        for i in s:
            if i == ' ':
                a.append('%20')
            else:
                a.append(i)
        return ''.join(a)

# 方法四：使用字符串
class Solution:
    def replaceSpace(self, s):
        m = ''
        for i in s:
            if i == ' ':
                m += '%20'
            else:
                m += i
        return m