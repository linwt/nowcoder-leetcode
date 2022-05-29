# 将单词、模板、两者组合成的元组去重，判断长度是否相等，以此判断是否匹配
class Solution(object):
    def findAndReplacePattern(self, words, pattern):
        return [word for word in words if self.isMatch(word, pattern)]

    def isMatch(self, word, pattern):
        if len(word) != len(pattern):
            return False
        return len(set(word)) == len(set(pattern)) == len(set(zip(word, pattern)))