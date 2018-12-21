# 统计两个句子中出现次数为1的单词
class Solution(object):
    def uncommonFromSentences(self, A, B):
        words = A.split() + B.split()
        d = collections.Counter(words)
        return [word for word in words if d[word]==1]