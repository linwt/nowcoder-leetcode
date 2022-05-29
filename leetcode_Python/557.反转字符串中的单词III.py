# 整体反转，再将单词位置反转
class Solution(object):
    def reverseWords(self, s):
        words = s[::-1].split(' ')[::-1]
        return ' '.join(word for word in words)

# 先切分单词，在逐个单词反转
class Solution(object):
    def reverseWords(self, s):
        return ' '.join(word[::-1] for word in s.split(' '))