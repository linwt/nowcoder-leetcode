class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        # 先按空格切分，再按逗号切分，然后去除每个词的标点字符
        words = [w.strip("!?';.") for word in paragraph.lower().split(' ') for w in word.split(',')]
        # 将不包含在禁用列表的单词添加到字典并累加次数
        d = {}
        for word in words:
            # 按逗号切分可能带来空单词，需要判断单词是否存在
            if word and word not in banned:
                d[word] = d.get(word, 0) + 1
        # 找出最大次数的单词
        max_times = max(d.values())
        for key in d:
            if d[key] == max_times:
                return key