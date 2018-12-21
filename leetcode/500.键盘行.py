class Solution(object):
    def findWords(self, words):
        row1, row2, row3 = 'qwertyuiop', 'asdfghjkl', 'zxcvbnm'
        res = []
        for word in words:
            # 找出该单词第一个字母属于哪一行
            for r in [row1, row2, row3]:
                if word[0].lower() in r:
                    row = r
            # 遍历字母，如果有字母不在该行则退出，否则将单词添加到数组中
            for w in word:
                if w.lower() not in row:
                    break
            else:
                res.append(word)
        return res