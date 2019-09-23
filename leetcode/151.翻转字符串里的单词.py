# 按空格切分单词再反转
class Solution(object):
    def reverseWords(self, s):
        return ' '.join(s.split()[::-1])