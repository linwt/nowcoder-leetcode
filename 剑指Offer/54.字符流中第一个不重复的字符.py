# 使用全局数组或字符串保存字符流
class Solution:
    def __init__(self):
        self.l = []
        # self.s = ''
    def FirstAppearingOnce(self):
        for i in self.l:
            if self.l.count(i)==1:
                return i
        return '#'
    def Insert(self, char):
        self.l.append(char)
        # self.s += char