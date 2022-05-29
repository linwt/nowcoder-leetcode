class Solution(object):
    def longestWord(self, words):
        words.sort()
        # 数组先保存一个空字符串
        res = ['']
        longestWord = ''
        for word in words:
            # 判断除去最后一个字符的字符串是否在数组中，若在则添加该字符串
            if word[:-1] in res:
                res.add(word)
                # 新字符串长度大于当前最长字符串时才更新，这样可在同等长度时保留字典序最小的单词
                if len(word) > len(longestWord):
                    longestWord = word
        return longestWord