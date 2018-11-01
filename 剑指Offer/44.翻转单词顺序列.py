# 字符串按空格切分成数组，反转数组后按空格分隔组成字符串
class Solution:
    def ReverseSentence(self, s):
        l = s.split(' ')
        return ' '.join(l[::-1])